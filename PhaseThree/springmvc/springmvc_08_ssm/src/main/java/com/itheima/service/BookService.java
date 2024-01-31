package com.itheima.service;

import com.itheima.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 保存
     * */
    public boolean save(Book book);
    /**
     * 修改
     * */
    public boolean update(Book book);
    /**
     * 删除
     * */
    public boolean delete(Integer id);
    /**
     * 按ID查询
     * */
    public Book getBookById(Integer id);
    /**
     * 查询所有
     * */
    public List<Book> getAll();

}
