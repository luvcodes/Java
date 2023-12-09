package com.itheima.dao;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
// 加Transactional是因为减少添加测试数据到DB中
// 这样就开启事务，不会提交新数据到DB中了
@Transactional
// 默认SpringBoot设置参数就是true (支持回滚)。
// 如果改成false，那么就会取消回滚。
@Rollback()
public class ServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("Spring Boot2");
        book.setType("IT2");
        book.setDescription("SpringBoot开发2");

        bookService.save(book);
    }
}
