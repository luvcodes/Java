package com.itheima.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    @Override
    public String findName(int id, String password) {
        System.out.println("id: " + id);
        System.out.println("password: " + password);
        return "itcast";
    }
}
