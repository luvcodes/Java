package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    // 配置基本数据类型
    // @Value("itheima")
    // private String name;

    // 配置外部property文件类型
    @Value("${name}")
    private String name;

    @Override
    public void save() {
        System.out.println("book dao save..." + name);
    }
}
