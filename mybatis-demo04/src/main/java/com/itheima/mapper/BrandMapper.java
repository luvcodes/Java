package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // 查询所有
    // 返回的应该是一个List集合
    public List<Brand> selectAll();

    // 查询详情，根据id查询
    Brand selectById(int id);

    /**
     * 条件查询
     *  参数接收:
     *      1. 散装参数: 如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      2. 对象参数: 只需要保证SQL中的参数名和实体类属性名对应上，即可设置成功
     *      3. map集合参数: 只需要保证SQL中的参数名和map集合的键的名称对应上，即可设置成功
     * */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    // List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);
}
