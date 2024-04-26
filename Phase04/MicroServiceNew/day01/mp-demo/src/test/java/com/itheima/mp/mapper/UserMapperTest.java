package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class UserMapperTest {

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
        User user = userMapper.selectById(5L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryByIds() {
        List<User> users = userMapper.selectBatchIds(List.of(1L, 2L, 3L, 4L));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDeleteUser() {
        userMapper.deleteById(5L);
    }

    // 使用条件查询来实现
    @Test
    void testQueryWrapper() {
        // 1. 构建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id", "username", "info", "balance")
                .like("username", "o")
                .ge("balance", 1000);
        List<User> users = userMapper.selectList(wrapper);
        // 2. 遍历打印
        // 2.1 增强for打印
        for (User user : users) {
            System.out.println(user);
        }
        // 2.2 迭代器打印
        /*Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        // 2.3 匿名内部类打印
        /*users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });*/
        // 2.4 lambda表达式打印
        // users.forEach(user -> System.out.println(user));
        // 2.5 方法引用打印
        // users.forEach(System.out::println);
    }

    @Test
    void testUpdateByQueryWrapper() {
        // 1. 构建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("username", "Jack");
        User user = new User();
        user.setBalance(2000);
        // 2. 执行更新，user中非null字段都会作为set语句
        userMapper.update(user, wrapper);
    }

    /**
     * 使用UpdateQueryWrapper来实现更新
     * 需求：更新id为1,2,4的用户的余额，扣200
     * */
    @Test
    void testUpdateWrapper() {
        List<Long> ids = List.of(1L, 2L, 3L);
        // 1. 生成SQL
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .in("id", ids);
        // 2. 更新，注意第一个参数可以给null，也就是不填更新字段和数据，而是基于UpdateWrapper中的setSQL来更新
        userMapper.update(null, wrapper);
    }

    /**
     * 选出名字中有o，余额大于1000的用户
     * 使用QueryWrapper调用lambda()方法
     * */
    @Test
    void testLambdaQueryWrapper() {
        // 1.构建条件 WHERE username LIKE "%o%" AND balance >= 1000
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(User::getId, User::getUsername, User::getInfo, User::getBalance)
                .like(User::getUsername, "o")
                .ge(User::getBalance, 1000);
        // 2. 查询
        System.out.println(userMapper.selectList(wrapper));
    }

    /**
     * 需求：将id在指定范围的用户（例如1、2、4 ）的余额扣减指定值200
     */
    @Test
    void testCustomSqlUpdate() {
        // 1. 更新条件
        List<Long> ids = List.of(1L, 2L, 4L);
        int amount = 200;
        // 2. 定义条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.in("id", ids);

        // 3. 调用自定义sql方法
        userMapper.updateBalanceByIds(wrapper, amount);
    }
}