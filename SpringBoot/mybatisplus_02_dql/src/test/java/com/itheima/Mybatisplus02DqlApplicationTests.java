package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 按条件查询
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.lt("age", 18);
//        List<User> userList = userDao.selectList(wrapper);
//        System.out.println(userList);

        // lambda按条件查询
//        QueryWrapper<User> wrapper = new QueryWrapper<User>();
//        wrapper.lambda().lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(wrapper);
//        System.out.println(userList);

        // lambda按条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);


        // 多条件
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, 30);
//        lqw.gt(User::getAge, 10);
        // 链式编程
//        lqw.lt(User::getAge, 30).gt(User::getAge, 10);

        // 10到30岁之间
//        lqw.lt(User::getAge, 30).gt(User::getAge, 10);
        // 小于10岁或者大于30岁
        lqw.lt(User::getAge, 30).or().gt(User::getAge, 10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    // 处理null值
    @Test
    void testGetAll2() {
        // 模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
        uq.setAge(10);
        uq.setAge2(30);

        // null判定
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        // 先判定第一个参数是否为true，如果为true连接当前条件
        lqw.lt(null != uq.getAge2(), User::getAge, uq.getAge2());
        lqw.gt(null != uq.getAge2(), User::getAge, uq.getAge());
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    // 查询投影
    @Test
    void testGetAll3() {
        // 使用lambda的方式
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.select(User::getId, User::getName, User::getAge);

        // 另一种方式
//        QueryWrapper<User> lqw = new QueryWrapper<User>();
//        lqw.select("id", "name", "age", "tel");
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

        QueryWrapper<User> lqw = new QueryWrapper<User>();
        // 统计有多少个数据
        lqw.select("count(*) as count, tel");
        lqw.groupBy("tel");
        List<Map<String, Object>> userList = userDao.selectMaps(lqw);
        System.out.println(userList);
    }

    // 条件查询
    @Test
    void testGetAll4() {
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        // 等同于 =
//        lqw.eq(User::getName, "Jerry").eq(User::getPassword, "jerry");
//        User loginUser = userDao.selectOne(lqw);
//        System.out.println(loginUser);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        // 范围查询 lt le gt ge eq between
//        lqw.between(User::getAge, 10, 30);
//        List<User> loginUser = userDao.selectList(lqw);
//        System.out.println(loginUser);

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


    @Test
    void test() {

    }
}
