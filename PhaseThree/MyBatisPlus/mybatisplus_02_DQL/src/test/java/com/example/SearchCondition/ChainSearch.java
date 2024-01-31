package com.example.SearchCondition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChainSearch {
    @Autowired
    private UserDao userDao;

    // 常规查询是这样的
    @Test
    void testGetAll() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.lt(User::getAge, 20);
        wrapper.gt(User::getAge, 10);
        List<User> list = userDao.selectList(wrapper);
        System.out.println(list);
    }

    // 链式编程来实现查询
    @Test
    void testGetAll2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.lt(User::getAge, 20).gt(User::getAge, 10);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }


}
