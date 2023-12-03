package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        Long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println("BookDao save...");
    }

    @Override
    public void update() {
        System.out.println("BookDao update...");
    }


}
