package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {}
