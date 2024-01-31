package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ryanw
 */
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    public Book getBookById(Integer id);
}
