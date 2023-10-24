package com.itheima;

import com.itheima.dao.impl.BookDao;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        // bookDao.save();
    }
}
