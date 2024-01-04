package org.ryanyang;

import org.junit.jupiter.api.Test;
import org.ryanyang.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemo1ApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("name", "mark");

        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:100", new User("ryan", 21));

        // 获取数据
        User o = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println("o = " + o);
    }
}
