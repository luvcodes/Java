package com.itheima.service;

import com.itheima.pojo.Dept;
import java.util.List;

/**
 * @author ryanw
 */
public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}
