package com.itheima;

import com.itheima.dao.impl.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceUser {
    public static void main(String[] args) {
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        UserDao userDao = userDaoFactory.getUserDao();
//        userDao.save();

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");
        UserDao userDao1 = (UserDao) classPathXmlApplicationContext.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao1);
        userDao.save();
    }
}
