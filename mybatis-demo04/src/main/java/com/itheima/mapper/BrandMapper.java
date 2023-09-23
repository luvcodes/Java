package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * */
    public List<Brand> selectAll();

    /**
     * 查看详情, 根据Id查询
     * */
    Brand selectById(int id);
}
