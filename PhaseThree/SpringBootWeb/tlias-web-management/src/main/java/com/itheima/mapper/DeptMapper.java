package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 * @author ryanw
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除指定部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
