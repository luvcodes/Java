package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;
import com.itheima.dao.impl.BookDaoImpl;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }
}
