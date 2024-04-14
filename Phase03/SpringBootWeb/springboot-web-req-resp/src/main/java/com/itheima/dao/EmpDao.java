package com.itheima.dao;

import com.itheima.pojo.Emp;

import java.util.List;

/**
 * @author ryanw
 */
public interface EmpDao {
    // 获取员工列表数据
    public abstract List<Emp> listEmp();
}
