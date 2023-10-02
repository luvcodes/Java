package com.itheima;

import com.itheima.dao.impl.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
//        ctx.close();


        // 第二种方式
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**
         * 这句话的意思就是，因为虚拟机是会在bean销毁之前就关闭了虚拟机，所以之前才会出现destroy无法执行的情况。
         * 但是现在注册销毁钩子，就意味着告诉JVM等到bean销毁之后再关闭虚拟机。
         * */
        ctx.registerShutdownHook();
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
