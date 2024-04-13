package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchProjection {
    @Autowired
    private UserDao userDao;

    // Lambda表达式实现查询投影
    @Test
    void testGetAll() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId, User::getName, User::getAge);
        List<User> users = userDao.selectList(wrapper);
        System.out.println(users);
        System.out.println("===============================");

    }

    // QueryWrapper实现查询投影
    @Test
    void testGetAll2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name", "age");
        List<User> users1 = userDao.selectList(queryWrapper);
        System.out.println(users1);
    }
}
