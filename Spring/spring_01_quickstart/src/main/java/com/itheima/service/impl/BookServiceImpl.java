package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }

    // 6. 提供setter方法
    // 这个setter方法是容器在执行
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
        System.out.println("calling the set method");
    }
}
