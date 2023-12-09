package com.itheima;

import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot17SqlApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void getById() {
        bookDao.selectById(1);
    }
}
