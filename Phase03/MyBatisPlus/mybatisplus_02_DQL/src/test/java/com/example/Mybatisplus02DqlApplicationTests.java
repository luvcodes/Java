package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    /**
     * 多条件查询
     * */
    @Test
    void testGetAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("age", 12);
        queryWrapper.ge("age", 4);
        List<User> userList = userDao.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    void testGetAll2() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lt("age", 30).gt("age", 10);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }

     @Test
     void testGetAll3() {
         // lambda按条件查询
         QueryWrapper<User> wrapper = new QueryWrapper<User>();
         wrapper.lambda().lt(User::getAge, 10).gt(User::getAge, 10);
         List<User> userList = userDao.selectList(wrapper);
         System.out.println(userList);
     }

     @Test
     void testGetAll4() {
         LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
         lqw.lt(User::getAge, 30).gt(User::getAge, 10);
         List<User> userList = userDao.selectList(lqw);
         System.out.println(userList);
     }

     /**
      * 使用or()范围查询
      * 10 岁 < 年龄 < 30 岁
      * 年龄 > 30 岁
      * */
     @Test
     void testGetAll5() {
         LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
         lqw.lt(User::getAge, 30).or().gt(User::getAge, 10);
         List<User> userList = userDao.selectList(lqw);
         System.out.println(userList);
     }

    // like查询
    @Test
    void testGetAll6() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        // 模糊匹配 like
        lqw.like(User::getName, "J");

        // 这个是%J的意思，Left就是百分号在左边
        // 这个匹配不上是因为，%J的意思是字符串最后结尾是J
        lqw.likeLeft(User::getName, "J");

        // 这个是J%的意思，Right就是百分号在右边
        // 这个能够匹配成功是因为，J%的意思是字符串开头是J
        lqw.likeRight(User::getName, "J");

        List<User> loginUser = userDao.selectList(lqw);
        System.out.println(loginUser);
    }

    // group分组查询
    @Test
    void testGetAll7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 统计有多少个数据
        queryWrapper.select("count (*) as count, tel");
        queryWrapper.groupBy("tel");
        List<Map<String, Object>> userList = userDao.selectMaps(queryWrapper);
        System.out.println(userList);
    }
}
