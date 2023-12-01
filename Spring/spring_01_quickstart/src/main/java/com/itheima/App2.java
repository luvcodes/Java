package com.itheima;

import com.itheima.service.impl.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        // 3. 获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 4. 获取bean
        // getBean方法里面的名字应该是xml文件里定义的id名字
        // BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        // bookDao.save();

        BookService bookService = (BookService) ctx.getBean("serviceDao");
        bookService.save();
    }
}
