package com.itheima;

import com.itheima.dao.impl.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForScope {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao1 = (BookDao) ctx.getBean("dao");
        BookDao bookDao2 = (BookDao) ctx.getBean("dao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);
    }
}
