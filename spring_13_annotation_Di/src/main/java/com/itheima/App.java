package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.impl.BookDao;
import com.itheima.service.impl.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}
