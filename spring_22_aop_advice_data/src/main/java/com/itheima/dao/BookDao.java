package com.itheima.dao;

import org.springframework.stereotype.Component;

@Component
public interface BookDao {
    public String findName(int id, String password);
}
