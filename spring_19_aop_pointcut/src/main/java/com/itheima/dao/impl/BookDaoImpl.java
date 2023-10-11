package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Override
    public void save() {
        Long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println("book dao save");
    }

    public void update() {
        System.out.println("book dao update");
    }
}
