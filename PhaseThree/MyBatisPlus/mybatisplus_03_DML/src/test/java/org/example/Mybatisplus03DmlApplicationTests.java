package org.example;

import org.example.domain.User;
import org.example.dto.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import java.util.ArrayList;

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

    /**
     * 测试逻辑删除
     * */
    @Test
    void testDelete() {
        List<Long> list = new ArrayList<Long>();
//        list.add(1721033084409384962L);
//        list.add(1721035040897036290L);
//        userDao.deleteBatchIds(list);

        userDao.deleteById(1752533337792716802L);
    }


    /**
     * 用于验证逻辑删除是否生效
     * */
    @Test
    void testSelect() {
//        List<Long> list = new ArrayList<Long>();
//        list.add(1L);
//        list.add(2L);
//        userDao.selectBatchIds(list);
        System.out.println(userDao.selectList(null));
    }

    /**
     * 测试乐观锁
     * */
    @Test
    void testUpdate() {
//        User user = new User();
//        user.setId(1752539431835492354L);
//        user.setName("Jock666");
//        user.setVersion(1);
//        userDao.updateById(user);


//        // 1. 先通过修改的数据id将当前数据查询出来
//        User user = userDao.selectById(1752539431835492354L);
//        // 2. 将要修改的属性逐一设置进去
//        user.setName("Jock888");
//        userDao.updateById(user);


        // 验证加锁的操作
        User user1 = userDao.selectById(1752539431835492354L);
        User user2 = userDao.selectById(1752539431835492354L);
        user2.setName("Jock999");
        userDao.updateById(user2);
        // 下面这条一定会失效，因为读的version值 还依然是上面Jock999之前的version值
        user1.setName("Jock101010");
        userDao.updateById(user1);
    }
}
