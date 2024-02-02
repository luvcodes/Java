package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;
import java.util.List;

/**
 * @author ryanw
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{create_time}, #{update_time})")
    void add(Dept dept);

    @Update("update dept set name = #{name}, create_time = #{create_time}, update_time = #{update_time} where id = #{id}")
    void update(Dept dept);
}
