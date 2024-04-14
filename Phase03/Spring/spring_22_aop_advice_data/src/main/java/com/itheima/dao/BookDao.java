package com.itheima.dao;

import org.springframework.stereotype.Component;

/**
 * @author ryanw
 */
@Component
public interface BookDao {
    public String findName(int id, String password);
}
