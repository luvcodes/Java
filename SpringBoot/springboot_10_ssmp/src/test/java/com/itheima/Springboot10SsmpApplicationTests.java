package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot10SsmpApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("description");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(7);
        book.setType("测试数据456");
        book.setName("测试数据456");
        book.setDescription("description");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(7);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage() {

    }

    @Test
    void testGetBy() {

    }
}
