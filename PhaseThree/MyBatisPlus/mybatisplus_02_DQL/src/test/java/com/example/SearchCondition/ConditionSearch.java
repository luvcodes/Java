package com.example.SearchCondition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.domain.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ConditionSearch {
    @Autowired
    private UserDao userDao;

    // 使用常规条件查询
    @Test
    void testGetAll() {
        /*QueryWrapper wrapper = new QueryWrapper();
        // age小于20岁
        wrapper.lt("age", 20);
        List<User> list = userDao.selectList(wrapper);
        System.out.println(list);*/

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        // age大于20岁
        wrapper.gt("age", 20);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }

    // 使用lambda表达式查询
    @Test
    void testGetAll2() {
        /*QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.lambda().lt(User::getAge, 20);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);*/
        System.out.println("================================");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().gt(User::getAge, 20);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
    }

    // 使用LambdaQueryWrapper表达式查询
    @Test
    void testGetAll3() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 查询User年龄小于20
        wrapper.lt(User::getAge, 20);
        List<User> userList = userDao.selectList(wrapper);
        System.out.println(userList);
        System.out.println("================================");

        // 查询User年龄大于20
        wrapper.gt(User::getAge, 20);
        List<User> userList1 = userDao.selectList(wrapper);
        System.out.println(userList1);
    }


    // eq方法查询
    @Test
    void testGetAll4() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // eq方法 就是 =
        wrapper.eq(User::getName, "Jerry").eq(User::getPassword, "jerry");
        User loginUser = userDao.selectOne(wrapper);
        System.out.println(loginUser);
    }

    // 范围查询 lt le gt ge eq between
    @Test
    void testGetAll5() {
        // 设置模拟数据
        UserQuery userQuery = new UserQuery();
        userQuery.setAge2(20);
        userQuery.setAge(10);


        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 方案一: 设定上限下限
        wrapper.le(User::getAge, userQuery.getAge2()).ge(User::getAge, userQuery.getAge());
        // 方案二: 设定范围
        /*wrapper.between(User::getAge, userQuery.getAge(), userQuery.getAge2());*/
        List<User> loginUser = userDao.selectList(wrapper);
        System.out.println(loginUser);
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
