package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.impl.BookDao;
import com.itheima.service.impl.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);

        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
