package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;
import com.itheima.dao.impl.BookDaoImpl;

public class BookServiceImpl implements BookService {
    // 5. 删除业务层中使用new的方式创建的DAO对象
//    private BookDao bookDao = new BookDaoImpl();
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
