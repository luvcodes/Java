package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.pojo.Dept;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ryanw
 */
public interface EmpService {
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin   开始时间
     * @param end     结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}