package com.itheima;

import com.itheima.dao.impl.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class App {
    public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 文件系统下加载配置文件
//        ApplicationContext ctx2 = new FileSystemXmlApplicationContext("C:\\Users\\ryanw\\IdeaProjects\\Java\\spring_10_container\\src\\main\\resources\\applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx2.getBean("bookDao");

        // Bean加载第一种方式
//        BookDao bookDao = ctx.getBean("bookDao", BookDao.class);
        // Bean加载第二种方式
//        BookDao bookDao = ctx.getBean(BookDao.class);
        // Bean加载第三种方式
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
