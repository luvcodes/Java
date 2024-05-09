package com.hmdp.service.impl;

import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisIdWorker;
import com.hmdp.utils.SimpleRedisLock;
import com.hmdp.utils.UserHolder;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;

/**
 * 服务实现类
 *
 * @author ryanw
 */
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {

    @Resource
    private ISeckillVoucherService iSeckillVoucherService;

    @Resource
    private RedisIdWorker redisIdWorker;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedissonClient redissonClient;

    // 连接lua脚本
    private static final DefaultRedisScript<Long> SECKILL_SCRIPT;
    static {
        SECKILL_SCRIPT = new DefaultRedisScript<>();
        SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

    /**
     * 优化秒杀   根据Lua脚本seckill.lua
     * */
    @Transactional
    @Override
    public Result secKillVoucher(Long voucherId) {
        // 获取用户
        Long userId = UserHolder.getUser().getId();

        // 1. 执行lua脚本
        Long result = stringRedisTemplate.execute(SECKILL_SCRIPT, Collections.emptyList(), voucherId.toString(), userId.toString());

        // 2. 判断结果是为0
        int r = result.intValue();
        if (r != 0) {
            // 2.1 不为0，代表没有购买资格
            return Result.fail(r == 1 ? "库存不足" : "不能重复下单");
        }

        // 2.2 为0，有购买资格，把下单信息保存到阻塞队列
        Long orderId = redisIdWorker.nextId("order");
        // 保存阻塞队列


        // 3. 返回订单id
        return Result.ok(orderId);
    }


    /**
     * @param voucherId 优惠券id
     * @return Result类型结果
     */
    /*@Transactional
    @Override
    public Result secKillVoucher(Long voucherId) {
        // 1. 查询优惠券
        SeckillVoucher voucher = iSeckillVoucherService.getById(voucherId);

        // 2. 判断秒杀是否开始
        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
            // 尚未开始
            return Result.fail("秒杀尚未开始！");
        }

        // 3. 判断秒杀是否已经结束
        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
            // 已经结束
            return Result.fail("秒杀尚未开始！");
        }

        // 4. 判断库存是否充足
        if (voucher.getStock() < 1) {
            // 库存不足
            return Result.fail("库存不足");
        }

        Long userId = UserHolder.getUser().getId();

        // 创建锁对象
        // SimpleRedisLock lock = new SimpleRedisLock("order:" + userId, stringRedisTemplate);

        // 使用redissonClient创建锁, 替代上面的自定义SimpleRedisLock
        RLock lock = redissonClient.getLock("lock:order:" + userId);

        // 尝试获取锁 (可重入)
        // 无参意思就是获取锁失败不等待
        // 如果指定参数，参数分别是: 获取锁的最大等待时间 (期间会重试), 锁自动释放时间，时间单位
        boolean isLock = lock.tryLock();

        // 判断是否获取锁成功
        if (!isLock) {
            // 获取锁失败，返回错误信息或重试
            return Result.fail("不允许重复下单");
        }

        try {
            // 获取代理对象 (事务)
            IVoucherOrderService proxy = (IVoucherOrderService) AopContext.currentProxy();

            return proxy.createVoucherOrder(voucherId);
        } finally {
            // 当前线程执行完成之后释放锁
            lock.unlock();
        }
    }*/

    /**
     * 这样就是应用了事务 + 锁，线程安全
     * 针对userId进行加锁，就可以保证只要userId的当前值一样，锁就肯定是一样的了。
     * toString方法取到具体的值，intern方法去字符串常量池找值一样的引用返回。
     * 比如说userId是5，无论new了多少个字符串，只要值是一样的，最后的结果就肯定是一样的
     */
    @Transactional
    @Override
    public Result createVoucherOrder(Long voucherId) {

        // 5. 一人一单
        Long userId = UserHolder.getUser().getId();
        // 针对userId加锁

        // 5.1 查询订单
        // 如果数据库中已经存在了user_id和voucher_id说明已经购买过
        int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
        // 5.2 判断数据库中是否存在order的记录
        if (count > 0) {
            return Result.fail("该用户已经购买过一次！");
        }

        // 6. 扣减库存
        boolean success = iSeckillVoucherService.update()
                .setSql("stock = stock - 1")
                // where id = ? and stock > 0
                .eq("voucher_id", voucherId)
                .gt("stock", 0)
                .update();
        if (!success) {
            // 扣减失败
            return Result.fail("内存不足");
        }

        // 7. 创建订单
        VoucherOrder voucherOrder = new VoucherOrder();
        Long orderId = redisIdWorker.nextId("order");
        voucherOrder.setId(orderId);
        voucherOrder.setUserId(userId);
        voucherOrder.setVoucherId(voucherId);

        save(voucherOrder);

        // 8. 返回订单id
        return Result.ok(orderId);
    }
}
