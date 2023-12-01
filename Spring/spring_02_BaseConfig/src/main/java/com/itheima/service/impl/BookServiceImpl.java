package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao;
    @Override
    public void save() {
        System.out.println("BookService save...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
        System.out.println("bookDao setter...");
    }
}
