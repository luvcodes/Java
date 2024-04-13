package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.domain.UserQuery;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NullValueHandle {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 设置模拟数据
        UserQuery userQuery = new UserQuery();
        userQuery.setAge2(20);
        userQuery.setAge(10);

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // null值判定
        // 在 userQuery.getAge2() 不为 null 的情况下，查找年龄在 10 到 20 之间的 User 对象。
        wrapper.lt(null != userQuery.getAge2(), User::getAge, userQuery.getAge2());
        wrapper.gt(null != userQuery.getAge2(), User::getAge, userQuery.getAge());
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }


    @Test
    void testGetAll2() {
        // 设置模拟数据
        UserQuery userQuery = new UserQuery();
        userQuery.setAge2(20);
        userQuery.setAge(10);

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 链式编程实现null值处理
        wrapper.lt(null != userQuery.getAge2(), User::getAge, userQuery.getAge2())
                .gt(null !=  userQuery.getAge(), User::getAge, userQuery.getAge());
        List<User> list = userDao.selectList(wrapper);
        System.out.println(list);
    }


    @Test
    void testGetAll3() {
        // 设置模拟数据
        UserQuery userQuery = new UserQuery();
        userQuery.setAge2(20);
        userQuery.setAge(10);

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // if语句控制条件追加
        if (null != userQuery.getAge2()) {
            wrapper.lt(User::getAge, userQuery.getAge());
        }
        if (null != userQuery.getAge2()) {
            wrapper.gt(User::getAge, userQuery.getAge2());
        }
        List<User> list = userDao.selectList(wrapper);
        System.out.println(list);
    }
}
