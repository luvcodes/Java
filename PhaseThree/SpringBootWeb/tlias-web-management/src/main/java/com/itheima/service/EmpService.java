package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

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

    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);

    /**
     * 保存员工信息
     * @param emp 员工对象
     */
    void save(Emp emp);

    /**
     * 根据ID查询员工
     * */
    Emp getById(Integer id);

    /**
     * 更新员工
     * */
    void update(Emp emp);
}
