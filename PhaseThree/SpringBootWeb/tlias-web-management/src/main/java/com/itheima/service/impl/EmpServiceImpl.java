package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ryanw
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     */
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 1. 获取总记录数
        Long count = empMapper.count();

        // 2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        // 3. 封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
