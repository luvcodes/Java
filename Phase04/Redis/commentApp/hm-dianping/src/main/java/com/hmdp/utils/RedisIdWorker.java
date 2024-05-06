package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author ryanw
 */
@Component
public class RedisIdWorker {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 根据2022年1月1日0点0分0秒生成
     * 开始时间戳
     * */
    private static final Long BEGIN_TIMESTAMP = 1640995200L;

    /**
     * 序列号
     * */
    private static final int COUNT_BITS = 32;

    /**
     * 为了实现redis的自增长
     *
     * @param keyPrefix 针对业务的名字前缀
     * @return Redis中保存的下一个id
     * 这个方法是为了实现秒杀的功能
     */
    public Long nextId(String keyPrefix) {
        // 1. 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond - BEGIN_TIMESTAMP;

        // 2. 生成序列号
        // 2.1 获取日期精准到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long count = stringRedisTemplate.opsForValue().increment("incre:" + keyPrefix + ":" + date);

        // 3. 拼接并返回
        // 先向左移把位置空出来，然后“或”count填充结果
        return timestamp << COUNT_BITS | count;
    }

}
