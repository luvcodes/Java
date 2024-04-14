package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface UserDao {
    @Insert("insert into tbl_user (name, age) values (#{name},#{age})")
    public void save(com.itheima.domain.UserDao user);
}
