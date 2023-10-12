package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.dao.impl.UserDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private UserDao userDao;

    // setter注入引用类型
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // setter注入引用类型
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save...");
        bookDao.save();
        userDao.save();
    }
}
