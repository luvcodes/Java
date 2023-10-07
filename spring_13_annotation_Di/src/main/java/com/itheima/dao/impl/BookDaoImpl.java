package com.itheima.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

//    // 配置基本数据类型
//    @Value("itheima")
//    private String name;

    @Value("${name}")
    private String name;

    @Override
    public void save() {
        System.out.println("book dao save..." + name);
    }
}
