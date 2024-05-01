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
        // 创建连接池对象。这里我将密码改成了123321，因为正在使用Linux远程连接redis
        // 如果是运行windows本地的redis，那么改成123456即可
        JEDIS_POOL = new JedisPool(jedisPoolConfig, "192.168.200.130",
                6379, 1000, "123321");
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
