package com.itheima;

import com.itheima.service.impl.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForName {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("dao");
//        bookDao.save();
        BookService bookService = (BookService) ctx.getBean("service");
        bookService.save();
    }
}
