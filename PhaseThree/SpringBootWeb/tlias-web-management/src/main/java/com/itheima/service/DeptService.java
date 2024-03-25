package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 * @author ryanw
 */
public interface DeptService {
    /**
     * 查询全部的部门数据
     * */
    List<Dept> list();

    /**
     * 根据id删除指定部门
     * */
    void delete(Integer id);
}
