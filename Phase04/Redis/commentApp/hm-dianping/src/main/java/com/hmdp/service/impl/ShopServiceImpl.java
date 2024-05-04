package com.hmdp.service.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 *  服务实现类
 * @author ryanw
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据id查询商铺
     * */
    @Override
    public Result queryById(Long id) {
        // 缓存穿透
        // Shop shop = queryWithPassThrough(id);

        // 互斥锁解决缓存击穿
        Shop shop = queryWithMutex(id);
        if (shop == null) {
            return Result.fail("店铺不存在！");
        }

        // 7. 返回
        return Result.ok(shop);

    }

    /**
     * 实现缓存穿透的代码
     * @param id shop_id
     * @return shop 返回shop对象
     * */
    public Shop queryWithMutex(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY + id;
        // 1. 从redis查询商铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(key);

        // 2. 判断商铺缓存信息是否存在于redis中
        if (StrUtil.isNotBlank(shopJson)) {
            // 3. 如果存在商铺，返回商铺信息
            // 这里返回商铺信息之前需要转成java对象返回，而不是字符串
            return JSONUtil.toBean(shopJson, Shop.class);
        }

        // 判断命中的是否是空字符串
        if (shopJson != null) {
            // 返回一个错误信息
            return null;
        }

        // 4. 开始实现缓存重建的代码，也就是缓存中查询商铺信息未命中
        // 4.1 获取互斥锁
        String lockKey = "lock:shop:" + id;
        Shop shop = null;
        try {
            boolean isLock = tryLock(lockKey);

            // 4.2 判断获取互斥锁是否成功
            if (!isLock) {
                // 4.3 如果获取失败，则休眠并重试
                Thread.sleep(50);
                // 重试，就是递归这个方法
                return queryWithMutex(id);
            }

            // 4.4 如果成功，根据id查询数据库
            shop = getById(id);
            // 模拟重建的延时
            Thread.sleep(200);

            // 5. 如果在4.4步骤中查询数据库也没有查到，返回错误
            if (shop == null) {
                // 将空值写入redis
                stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
                // 返回错误信息
                return null;
            }

            // 6. 如果4.4步骤中查询数据库查到了商铺信息，写入redis
            stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 7. 释放互斥锁
            unlock(lockKey);
        }

        // 8. 返回
        return shop;
    }

    /**
     * @param id 店铺id
     * @return shop
     * 这里是定义缓存击穿部份的代码，在上面实现根据id查询商铺的方法中只要调用这个方法就是实现了
     * */
    public Shop queryWithPassThrough(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY + id;
        // 1. 从redis查询商铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(key);

        // 2. 判断商铺缓存信息是否存在于redis中
        if (StrUtil.isNotBlank(shopJson)) {
            // 3. 如果存在商铺，返回商铺信息
            // 这里返回商铺信息之前需要转成java对象返回，而不是字符串
            ;
            return JSONUtil.toBean(shopJson, Shop.class);
        }

        // 判断命中的是否是空字符串
        if (shopJson != null) {
            // 返回一个错误信息
            return null;
        }

        // 4. 若不存在，根据商铺id查询数据库
        Shop shop = getById(id);

        // 5 如果商铺不存在，返回错误信息
        if (shop == null) {
            // 这里本来是直接返回错误信息，但是考虑到缓存穿透的风险
            // 将空值写入redis，再返回错误信息。
            stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
            return null;
        }

        // 6. 如果商铺存在，将商铺信息写入redis，并返回
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);

        // 7. 返回
        return shop;
    }


    /**
     * 这是为了解决缓存击穿问题，使用互斥锁的方式来实现
     * 尝试获取锁
     * */
    private boolean tryLock(String key) {
        // 获取锁
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(RedisConstants.CACHE_SHOP_KEY, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    /**
     * 对应上面的获取锁
     * 释放锁
     * */
    private void unlock(String key) {
        stringRedisTemplate.delete(key);
    }



    /**
     * 更新商铺信息
     * @param shop
     * @return
     * 确定了采用删除策略，来解决双写问题，当我们修改了数据之后，
     * 然后把缓存中的数据进行删除，查询时发现缓存中没有数据，则会从mysql中加载最新的数据，
     * 从而避免数据库和缓存不一致的问题。
     */
    @Override
    @Transactional
    public Result update(Shop shop) {
        Long id = shop.getId();
        if (id == null) {
            return Result.fail("店铺id不能为空");
        }

        // 1. 更新数据库
        updateById(shop);
        // 2. 删除缓存
        stringRedisTemplate.delete(RedisConstants.CACHE_SHOP_KEY + id);

        return Result.ok();
    }
}
