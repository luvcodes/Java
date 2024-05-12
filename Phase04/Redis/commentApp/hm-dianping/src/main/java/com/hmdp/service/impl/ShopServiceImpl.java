package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.SystemConstants;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.SHOP_GEO_KEY;
import static com.hmdp.utils.SystemConstants.DEFAULT_PAGE_SIZE;

/**
 * 服务实现类
 *
 * @author ryanw
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    /**
     * 根据id查询商铺
     */
    @Override
    public Result queryById(Long id) {
        // 缓存穿透
        // Shop shop = cacheClient.queryWithPassThrough(RedisConstants.CACHE_SHOP_KEY, id, Shop.class, this::getById, RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);

        // 互斥锁解决缓存击穿
        // Shop shop = queryWithMutex(id);
        // if (shop == null) {
        //     return Result.fail("店铺不存在！");
        // }

        // 逻辑过期解决缓存击穿
        // Shop shop = queryWithLogicalExpire(id);
        Shop shop = cacheClient
                .queryWithLogicalExpire(RedisConstants.CACHE_SHOP_KEY, id,
                        Shop.class, this::getById, RedisConstants.CACHE_SHOP_TTL,
                        TimeUnit.MINUTES);

        if (shop == null) {
            return Result.fail("店铺不存在！");
        }

        return Result.ok(shop);
    }

    /**
     * 更新商铺信息
     *
     * @param shop 商铺对象
     * @return 确定了采用删除策略，来解决双写问题，当我们修改了数据之后，
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

    /**
     * 根据商铺类型分页查询商铺信息
     *
     * @param typeId  商铺的类型id
     * @param current 当前页码
     * @param x       横坐标
     * @param y       纵坐标
     * @return Result规范输出格式
     */
    @Override
    public Result queryShopByType(Integer typeId, Integer current, Double x, Double y) {
        // 1.判断是否需要根据坐标查询
        // 如果任一坐标值为null，需要使用数据库查询
        if (x == null || y == null) {
            // 按数据库查询
            Page<Shop> page = query()
                    .eq("type_id", typeId)
                    .page(new Page<>(current, DEFAULT_PAGE_SIZE));
            // 返回数据
            return Result.ok(page.getRecords());
        }

        // 2.计算分页参数
        // 因为页码通常从1开始计数，而数据索引是从0开始。
        // 所以，如果你在第1页（current = 1），应该从索引0开始读取数据。
        // 这个计算确定了当前页的第一个元素在数据集中的位置。
        // 例如，如果每页有10项 (DEFAULT_PAGE_SIZE = 10)，那么第3页的起始索引是 (3 - 1) * 10 = 20
        int from = (current - 1) * DEFAULT_PAGE_SIZE;
        // 这个计算确定了当前页的最后一个元素在数据集中的结束位置（实际上这个位置是下一页的起始位置，
        // 所以在实际使用时通常还要减去1）
        int end = current * DEFAULT_PAGE_SIZE;

        // 3.查询redis、按照距离排序、分页。结果：shopId、distance
        String key = SHOP_GEO_KEY + typeId;
        // GEOSEARCH key BYLONLAT x y BYRADIUS 10 WITHDISTANCE
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = stringRedisTemplate.opsForGeo()
                .search(
                        key,
                        GeoReference.fromCoordinate(x, y),
                        new Distance(5000),
                        RedisGeoCommands.GeoSearchCommandArgs.newGeoSearchArgs().includeDistance().limit(end)
                );

        // 4.解析出id
        if (results == null) {
            return Result.ok(Collections.emptyList());
        }

        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list = results.getContent();
        // 尽管用户请求了第 current 页，但数据源中的数据不足以填充到这一页
        // 所以有可能出现list.size() <= from 这种情况
        if (list.size() <= from) {
            // 没有下一页了，结束
            return Result.ok(Collections.emptyList());
        }

        // 4.1.截取 from ~ end的部分
        List<Long> ids = new ArrayList<>(list.size());
        Map<String, Distance> distanceMap = new HashMap<>(list.size());
        list.stream().skip(from).forEach(result -> {
            // 4.2.获取店铺id
            String shopIdStr = result.getContent().getName();
            ids.add(Long.valueOf(shopIdStr));
            // 4.3.获取距离
            Distance distance = result.getDistance();
            distanceMap.put(shopIdStr, distance);
        });

        // 5.根据id查询Shop
        String idStr = StrUtil.join(",", ids);
        List<Shop> shops = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();
        for (Shop shop : shops) {
            shop.setDistance(distanceMap.get(shop.getId().toString()).getValue());
        }

        // 6.返回
        return Result.ok(shops);
    }


    /**
     * 逻辑过期解决缓存击穿的代码，在上面实现根据id查询商铺的方法中只要调用这个方法就是实现了
     * 缓存击穿使用逻辑过期解决
     */
    /*public Shop queryWithLogicalExpire(Long id) {
        String key = RedisConstants.CACHE_SHOP_KEY + id;
        // 1. 从redis查询商铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(key);

        // 2. 判断商铺缓存信息是否存在于redis中
        if (StrUtil.isBlank(shopJson)) {
            // 3. 如果查询缓存未空，也就是未命中，那么直接返回空
            return null;
        }

        // 4. 如果查询缓存命中，需要先把json反序列化为对象
        RedisData redisData = JSONUtil.toBean(shopJson, RedisData.class);
        JSONObject data = (JSONObject) redisData.getData();
        Shop shop = JSONUtil.toBean(data, Shop.class);
        LocalDateTime expireTime = redisData.getExpireTime();

        // 5. 判断是否过期
        if (expireTime.isAfter(LocalDateTime.now())) {
            // 5.1 未过期，直接返回商铺信息
            return shop;
        }

        // 5.2 已过期，需要缓存重建

        // 6. 缓存重建
        // 6.1 获取互斥锁
        String lockKey = RedisConstants.LOCK_SHOP_KEY + id;
        boolean isLock = tryLock(lockKey);
        // 6.2 判断是否获取锁成功
        if (isLock) {
            // 6.3 成功，开启独立线程，实现缓存重建
            CACHE_REBUILD_EXECUTOR.submit(() -> {
                try {
                    // 重建缓存
                    this.saveShop2Redis(id, 20L);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    // 释放锁
                    unlock(lockKey);
                }
            });
        }

        // 6.4 失败，返回过期的商铺信息
        return shop;
    }*/

    // 创建线程池
    // private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

    /**
     * 互斥锁解决缓存穿透的代码
     * @param id shop_id
     * @return shop 返回shop对象
     */
    /*public Shop queryWithMutex(Long id) {
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
    }*/

    /**
     * 这里是定义缓存击穿部份的代码，在上面实现根据id查询商铺的方法中只要调用这个方法就是实现了
     * */
    /*public Shop queryWithPassThrough(Long id) {
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
    }*/

    /**
     * 针对缓存击穿的问题，实现逻辑过期业务
     */
    /*public void saveShop2Redis(Long id, Long expireSeconds) throws InterruptedException {
        // 1. 查询店铺数据
        Shop shop = getById(id);
        // 给一些延迟，为了验证是不是出现安全问题
        Thread.sleep(200);

        // 2. 封装逻辑过期时间
        RedisData redisData = new RedisData();
        redisData.setData(shop);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(expireSeconds));

        // 3. 写入过期时间
        String key = RedisConstants.CACHE_SHOP_KEY + id;
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
    }*/

    /**
     * 这是为了解决缓存击穿问题，使用互斥锁的方式来实现
     * 尝试获取锁
     */
    /*private boolean tryLock(String key) {
        // 获取锁
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(RedisConstants.CACHE_SHOP_KEY, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }*/

    /**
     * 对应上面的获取锁
     * 释放锁
     */
    /*private void unlock(String key) {
        stringRedisTemplate.delete(key);
    }*/


}
