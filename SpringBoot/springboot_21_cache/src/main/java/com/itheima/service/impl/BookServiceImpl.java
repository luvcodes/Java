package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    // 这个hashmap就是缓存
    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();

    @Override
    public Book getById(Integer id) {
        // 如果当前缓存中没有本次要查询的数据，则进行查询。如果有，就直接从缓存中获取数据返回。
        Book book = cache.get(id);
        if (book == null) {
            Book queryBook = bookDao.selectById(id); // 查数据
            cache.put(id, queryBook); // 把查出来的放进cache里

            return queryBook; // 返回查出来的数据。
        }
        // 因为走了判断，所以下面这样就证明了book不是null
        return cache.get(id);
    }


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
