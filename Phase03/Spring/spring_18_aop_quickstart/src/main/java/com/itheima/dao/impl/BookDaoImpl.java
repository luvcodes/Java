package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author ryanw
 */
@Repository
public class BookDaoImpl implements BookDao {
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
