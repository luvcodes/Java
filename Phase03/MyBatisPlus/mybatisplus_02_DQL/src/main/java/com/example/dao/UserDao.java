package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ryanw
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
