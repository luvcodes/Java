package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {
    // 如果查很多个就是List，一个就是User对象即可
    // 这里selectAll对应的是sql语句的id
    List<User> selectAll();
}
