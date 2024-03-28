package com.itheima.service;

import com.itheima.pojo.PageBean;

import java.time.LocalDate;

/**
 * 员工管理
 * @author ryanw
 */
public interface EmpService {
    /**
     * 条件分页查询
     * @param page 页码
     * @param pageSize 每页展示记录数
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
