package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot18RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("age", 41);
    }

    @Test
    void get() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object age = valueOperations.get("age");
        System.out.println(age);
    }

    @Test
    void hset() {
        HashOperations opsedForHash = redisTemplate.opsForHash();
        opsedForHash.put("info", "b", "b");
    }

    @Test
    void hget() {
        HashOperations opsedForHash = redisTemplate.opsForHash();
        Object o = opsedForHash.get("info", "b");
        System.out.println(o);
    }
}
