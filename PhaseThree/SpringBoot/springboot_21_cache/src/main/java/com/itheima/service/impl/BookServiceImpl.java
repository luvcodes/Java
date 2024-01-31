package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * cacheSpace是自定义的
     * 两个操作 (因为要验证缓存的结果，所以运行了两次):
     * 1. 设置。第一操作这个方法的时候，id在空间内没有值，那么就会把返回值塞到cacheSpace中
     * 2. 先检查，发现cacheSpace中有没有这个值，如果没有，执行第一步; 如果有，就直接把#id拿到
     * */
    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        Book book = bookDao.selectById(id);
        return book;
    }

    // 这个hashmap就是缓存
    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();

//    @Override
//    public Book getById(Integer id) {
//        // 如果当前缓存中没有本次要查询的数据，则进行查询。如果有，就直接从缓存中获取数据返回。
//        Book book = cache.get(id);
//        if (book == null) {
//            Book queryBook = bookDao.selectById(id); // 查数据
//            cache.put(id, queryBook); // 把查出来的放进cache里
//
//            return queryBook; // 返回查出来的数据。
//        }
//        // 因为走了判断，所以下面这样就证明了book不是null
//        return cache.get(id);
//    }


    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
