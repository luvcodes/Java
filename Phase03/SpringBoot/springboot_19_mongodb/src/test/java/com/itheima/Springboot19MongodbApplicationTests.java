package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.itheima.domain.Book;

import java.util.List;

@SpringBootTest
class Springboot19MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setName("java2");
        book.setType("springboot2");
        book.setDescription("springboot2");

        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        System.out.println(bookList);
    }

}
