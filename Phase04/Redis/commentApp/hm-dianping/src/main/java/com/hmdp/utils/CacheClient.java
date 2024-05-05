package com.hmdp.utils;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author ryanw
 */
@Component
@Slf4j
public class CacheClient {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public CacheClient(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void set(String key, Object value, Long time, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, unit);
    }

    /**
     * set逻辑过期
     * */
    public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit) {
        // 设置逻辑过期
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));

        // 写入redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
    }

    /**
     * 解决缓存穿透通用代码
     * */
    public <R, ID> R queryWithPassThrough(
            String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback,
            Long time, TimeUnit unit) {

        String key = keyPrefix + id;

        // 1. 从redis查询商铺缓存
        String json = stringRedisTemplate.opsForValue().get(key);

        // 2. 判断商铺缓存信息是否存在于redis中
        if (StrUtil.isNotBlank(json)) {
            // 3. 如果存在商铺，返回商铺信息
            // 这里返回商铺信息之前需要转成java对象返回，而不是字符串
            ;
            return JSONUtil.toBean(json, type);
        }

        // 判断命中的是否是空字符串
        if (json != null) {
            // 返回一个错误信息
            return null;
        }

        // 4. 若不存在，根据商铺id查询数据库
        // 这里使用了一个函数式编程，在参数里传递函数逻辑，然后查询数据库
        // Shop shop = getById(id);
        R r = dbFallback.apply(id);

        // 5 如果商铺不存在，返回错误信息
        if (r == null) {
            // 这里本来是直接返回错误信息，但是考虑到缓存穿透的风险
            // 将空值写入redis，再返回错误信息。
            stringRedisTemplate.opsForValue().set(key, "", RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);
            return null;
        }

        // 6. 如果商铺存在，将商铺信息写入redis，并返回
//        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(r), RedisConstants.CACHE_SHOP_TTL, TimeUnit.MINUTES);
        this.set(key, r, time, unit);

        // 7. 返回
        return r;
    }


    /**
     * 通用型缓存击穿
     */
    public <R, ID> R queryWithLogicalExpire(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long time, TimeUnit unit) {
        String key = keyPrefix + id;

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
        R r = JSONUtil.toBean(data, type);
        LocalDateTime expireTime = redisData.getExpireTime();

        // 5. 判断是否过期
        if (expireTime.isAfter(LocalDateTime.now())) {
            // 5.1 未过期，直接返回商铺信息
            return r;
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
                    // 查询数据库
                    R r1 = dbFallback.apply(id);
                    // 写入redis
                    this.setWithLogicalExpire(key, r1, time, unit);
                } catch (Exception e) {

                } finally {

                }
            });
        }

        // 6.4 失败，返回过期的商铺信息
        return r;
    }

    // 创建线程池
    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

    /**
     * 互斥锁解决缓存击穿问题
     */
    private boolean tryLock(String key) {
        // 获取锁
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(RedisConstants.CACHE_SHOP_KEY, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    /**
     * 对应上面的获取锁
     * 释放锁
     */
    private void unlock(String key) {
        stringRedisTemplate.delete(key);
    }

}
