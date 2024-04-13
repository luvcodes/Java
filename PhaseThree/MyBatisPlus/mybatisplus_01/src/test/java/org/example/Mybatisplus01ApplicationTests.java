package org.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.domain.User;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlus01ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSave() {
        User user = new User();
        user.setName("Java后端程序员");
        user.setPassword("123456");
        user.setAge(12);
        user.setTel("1006184000");

        userMapper.insert(user);
    }

    @Test
    void testDelete() {
        userMapper.deleteById(1720659325802409985L);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setName("updateName");

        userMapper.updateById(user);
    }

    @Test
    void testGetById() {
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    void testGetAll() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page(1, 2);
        userMapper.selectPage(page, null);
        System.out.println("Current page number: " + page.getCurrent());
        System.out.println("Current page size: " + page.getSize());
        System.out.println("Total page number: " + page.getPages());
        System.out.println("Total record number: " + page.getTotal());
        System.out.println("================================================");
        System.out.println("Get the specific records: " + page.getRecords());
    }

}
