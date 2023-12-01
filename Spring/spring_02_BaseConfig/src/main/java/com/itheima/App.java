package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Get the IoC container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // get the bean of bookDao
        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
//        bookDao1.save();

        // 验证这两个实例不是同一个对象
        if (bookDao1 != bookDao2) {
            System.out.println("prototype作用域正常工作，得到的两个实例不是同一个对象。");
        } else {
            System.out.println("prototype作用域未正常工作，得到的两个实例是同一个对象。");
        }
    }
}
