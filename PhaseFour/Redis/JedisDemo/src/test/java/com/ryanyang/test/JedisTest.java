package com.ryanyang.test;

import com.ryanyang.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 1. 建立连接
        // 指定ip和端口号
//        jedis = new Jedis("127.0.0.1", 6379);

        jedis = JedisConnectionFactory.getJedis();

        // 2. 设置密码
        jedis.auth("123456");

        // 3. 选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 存入数据
        String s = jedis.set("name", "mark");
        System.out.println("result = " + s);
        // 获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash() {
        // 插入hash数据
        jedis.hset("user:1", "name", "mark");
        jedis.hset("user:1", "age", "21");
        // 获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
