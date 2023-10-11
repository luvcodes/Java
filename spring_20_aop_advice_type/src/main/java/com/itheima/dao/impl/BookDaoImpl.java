package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Override
    public void update() {
        System.out.println("BookDao update is running");
    }

    @Override
    public int select() {
        System.out.println("BookDao select is running");
        return 100;
    }
}
