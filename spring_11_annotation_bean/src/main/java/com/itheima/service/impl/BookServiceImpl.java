package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
        System.out.println("calling the set method");
    }
}
