package com.hmdp.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.entity.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
}
