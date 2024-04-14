package com.itheima.app;

import com.itheima.config.SpringConfig8;
import com.itheima.service.impl.BookServiceImpl1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App8 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookServiceImpl1 bookService = context.getBean("bookService", BookServiceImpl1.class);
        bookService.check();
    }
}
