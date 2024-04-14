package com.ryanyang.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ryanw
 */
public class JedisConnectionFactory {
    private static final JedisPool JEDIS_POOL;

    static {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);
        // 空闲连接
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        // 等待时长1000ms就会报错了
        jedisPoolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象
        JEDIS_POOL = new JedisPool(jedisPoolConfig, "127.0.0.1",
                6379, 1000, "123456");
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
