package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.query.UserQuery;
import org.apache.ibatis.annotations.Delete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class Mybatisplus03DmlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testSave() {
        User user = new User();
        user.setName("后端程序员");
        user.setPassword("backend");
        user.setAge(12);
        user.setTel("4006184000");
        userDao.insert(user);
    }

    @Test
    void testDelete() {
        List<Long> list = new ArrayList<Long>();
//        list.add(1721033084409384962L);
//        list.add(1721035040897036290L);
//        userDao.deleteBatchIds(list);
        userDao.deleteById(2L);
    }

    @Test
    void testUpdate() {
//        User user = new User();
//        user.setId(3L);
//        user.setName("Jock666");
//        user.setVersion(1);
//        userDao.updateById(user);

//        // 1. 先通过修改的数据id将当前数据查询出来
//        User user = userDao.selectById(3L);
//        // 2. 将要修改的属性逐一设置进去
//        user.setName("Jock888");
//        userDao.updateById(user);


        User user1 = userDao.selectById(3L);
        User user2 = userDao.selectById(3L);

        user2.setName("Jock888");
        userDao.updateById(user2);

        // 1. 先通过修改的数据id将当前数据查询出来

        // 2. 将要修改的属性逐一设置进去
        user1.setName("Jock888");
        userDao.updateById(user1);
    }

    @Test
    void testSelect() {
//        List<Long> list = new ArrayList<Long>();
//        list.add(1L);
//        list.add(2L);
//        userDao.selectBatchIds(list);
        System.out.println(userDao.selectList(null));
    }

}
