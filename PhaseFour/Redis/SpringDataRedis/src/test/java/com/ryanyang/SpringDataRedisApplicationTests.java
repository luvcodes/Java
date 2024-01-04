package com.ryanyang;

import com.ryanyang.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testString() {
        // insert value
        redisTemplate.opsForValue().set("name", "mark");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:1", new User("ryan", 21));

        Object user = redisTemplate.opsForValue().get("user:1");
        System.out.println(user);
    }

}
