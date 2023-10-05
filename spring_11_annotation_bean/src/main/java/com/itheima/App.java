package com.itheima;

import com.itheima.dao.impl.BookDao;
import com.itheima.service.impl.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);

        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
