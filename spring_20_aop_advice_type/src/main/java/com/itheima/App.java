package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.impl.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        BookDao bookDao = ctx.getBean(BookDao.class);
//        bookDao.update();

        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao2 = ctx2.getBean(BookDao.class);
        int num = bookDao2.select();
        System.out.println(num);
    }
}
