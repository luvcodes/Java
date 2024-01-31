package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface BookDao {

//    @Insert("insert into tbl_book values (null, #{type}, #{name}, #{description})")
    @Insert("insert into tbl_book (type, name, description) values (#{type}, #{name}, #{description})")
    public void save(Book book);

    @Update("update tbl_book set type=#{type}, name=#{name}, description=#{description} where id = #{id}")
    public void update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public void delete(Integer book);

    @Select("select * from tbl_book where id = #{id}")
    public Book getBookById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getAll();
}
