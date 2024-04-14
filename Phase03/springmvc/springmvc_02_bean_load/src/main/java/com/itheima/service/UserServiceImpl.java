package com.itheima.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    public void save() {
        System.out.println("user save...");
    }
}
