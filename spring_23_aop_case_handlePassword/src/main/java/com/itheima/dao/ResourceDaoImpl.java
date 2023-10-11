package com.itheima.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ResourceDaoImpl implements ResourceDao{
    @Override
    public boolean readResources(String url, String password) {
        System.out.println(password.length());
        // 模拟校验
        return password.equals("root");
    }
}
