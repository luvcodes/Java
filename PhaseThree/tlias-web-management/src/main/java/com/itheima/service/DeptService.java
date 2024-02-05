package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * @author ryanw
 */
public interface DeptService {
    /**
     * 查询所有的部门数据
     * @return   存储Dept对象的集合
     */
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept 部门对象
     */
    void add(Dept dept);
}
