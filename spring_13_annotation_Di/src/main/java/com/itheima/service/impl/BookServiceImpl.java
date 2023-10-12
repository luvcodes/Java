package com.itheima.service.impl;

import com.itheima.dao.impl.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    // 正确的方法不推荐直接使用@Autowired("bean名称"), 这的bean名称其实就是BookDaoImpl和BookDaoImpl2的Respository的名称
    // 应该使用Qualifier来区分相同类型的bean，在这里只是为了演示有两个BookDao的时候怎么办
    // 其实很少定义两个相同类型的bean，如果有，那么就用Qualifier
    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }
}
