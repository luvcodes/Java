package com.itheima.dao;

import org.apache.ibatis.annotations.Mapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    Book getBookById(Integer id);
}
