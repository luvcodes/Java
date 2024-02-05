package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ryanw
 */
@Mapper
public interface EmpMapper {
/*    @Select("select * from emp")
    public List<Emp> list();*/

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    // 会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


    // @Update注解也可以用XML配置文件来替代
    /*@Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")*/
    public void update(Emp emp);


    // 根据id查询
    // @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    public Emp getById(Integer id);


    // 模糊查询实现查询name，精准查询gender，范围查询入职时间。就是搜索框中的内容
    // 下面这里应为使用了XML配置文件来替代所以可以注释掉
//    @Select("select * from emp where name like concat('%', #{name}, '%')" +
//            "and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} " +
//            "order by update_time desc")
    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);


    // 批量删除
    public void deleteByIds(List<Integer> ids);
}
