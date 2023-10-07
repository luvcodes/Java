package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.impl.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        BookDao bookDao1 = ctx.getBean(BookDao.class);
        System.out.println(bookDao);
        System.out.println(bookDao1);
        ctx.close();
    }
}
