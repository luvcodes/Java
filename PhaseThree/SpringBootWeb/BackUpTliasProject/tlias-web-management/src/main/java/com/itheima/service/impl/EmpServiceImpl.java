package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ryanw
 */
@Service
@Slf4j
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 条件分页查询
     *
     * @param page     页码
     * @param pageSize 每页展示记录数
     */
    /*@Override
    public PageBean page(Integer page, Integer pageSize) {
        // 1. 获取总记录数
        Long count = empMapper.count();

        // 2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        // 3. 封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }*/
    // 改进分页功能
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行条件分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        //获取查询结果
        Page<Emp> p = (Page<Emp>) empList;
        //封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /**
     * 批量删除操作
     *
     * @param ids id集合
     */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    /**
     * 保存员工信息
     *
     * @param emp 员工对象
     */
    @Override
    public void save(Emp emp) {
        // 补全数据
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // 调用添加方法
        empMapper.insert(emp);
    }

    /**
     * 根据ID查询员工
     *
     * @param id 员工id
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 更新员工
     *
     * @param emp 目标员工更新
     */
    @Override
    public void update(Emp emp) {
        // 更新修改时间为当前时间
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 员工登录
     */
    @Override
    public Emp login(Emp emp) {
        // 调用dao层功能：登录
        return empMapper.getByUsernameAndPassword(emp);
    }
}
