package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ryanw
 */
@Mapper
public interface EmpMapper {
    //获取当前页的结果列表
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}
