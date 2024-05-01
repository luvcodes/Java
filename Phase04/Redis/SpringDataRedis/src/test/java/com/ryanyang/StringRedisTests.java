package com.ryanyang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanyang.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class StringRedisTests {
    // 用这样的方式写的话，就不需要config.RedisConfig文件中的定义了
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("age", "18");
        Object age = stringRedisTemplate.opsForValue().get("age");
        System.out.println(age);
    }


    @Test
    void testSaveUser() throws JsonProcessingException {
        User user = new User("mark", 22);
        // 手动序列化
        String json = mapper.writeValueAsString(user);
        // 导入数据
        stringRedisTemplate.opsForValue().set("user:2", json);
        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:2");
        // 手动反序列化
        mapper.readValue(jsonUser, User.class);
        System.out.println("User2 = " + user);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:3", "name", "mark");
        stringRedisTemplate.opsForHash().put("user:3", "age", "21");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println(entries);
    }

    @Test
    void testHash2() {
        stringRedisTemplate.opsForHash().put("myhash1","key1", "value1");
        stringRedisTemplate.opsForHash().put("myhash2","key2", "value2");
        stringRedisTemplate.opsForHash().put("myhash1", "key2", "value2");

        System.out.println(stringRedisTemplate.opsForHash().get("myhash1", "key1"));
        System.out.println(stringRedisTemplate.opsForHash().get("myhash1", "key2"));
    }

}
