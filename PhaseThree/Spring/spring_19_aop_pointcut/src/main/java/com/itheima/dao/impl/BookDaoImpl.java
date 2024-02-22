package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;
import com.itheima.dao.BookDao;

/**
 * @author ryanw
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Override
    public void save() {
        Long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println("book dao save");
    }

    @Override
    public void update() {
        System.out.println("book dao update");
    }
}
