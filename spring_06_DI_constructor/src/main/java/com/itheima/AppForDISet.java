package com.itheima;

import com.itheima.dao.impl.BookDao;
import com.itheima.service.impl.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDISet {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
