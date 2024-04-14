package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Component;

/**
 * @author ryanw
 */
@Component
public class BookDaoImpl implements BookDao {
    @Override
    public String findName(int id, String password) {
        System.out.println("id: " + id);
        System.out.println("password: " + password);
        return "itcast";
    }
}
