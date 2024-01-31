package com.example.SearchCondition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrMethod {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.lt(User::getAge, 10).or().gt(User::getAge, 20);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }
}
