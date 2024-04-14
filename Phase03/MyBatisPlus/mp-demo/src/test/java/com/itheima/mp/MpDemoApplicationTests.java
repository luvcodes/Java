package com.itheima.mp;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
class MpDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(5L);
        user.setUsername("Lucy");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }

    @Test
    void testSelectByIds() {
        List<Long> listIds = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(listIds);
        // 第一种方式 在增强for
        /*for (User user : users) {
            System.out.println(user);
        }*/

        // 第二种遍历 普通for循环
        /*for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/

        // 第三种遍历 迭代器遍历
        /*Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }*/

        // 第四种遍历 forEach遍历
        users.forEach((user) -> System.out.println(user));
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDelete() {
        userMapper.deleteById(5L);
    }
}
