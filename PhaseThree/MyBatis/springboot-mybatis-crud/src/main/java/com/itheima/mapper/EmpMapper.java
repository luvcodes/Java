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
    /**
     * 删除单个emp
     * */
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    /**
     * 插入新emp
     * */
    // 会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, " +
            "#{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


    // @Update注解也可以用XML配置文件来替代
    /**
     * 根据id修改员工信息
     */
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    /**
     * 根据id查询员工, 需要返回类型
     * */
    // 这样写有三个字段封装不上，因为字段名与属性名不一致。
    /*@Select("select * from emp where id = #{id}")
    public Eemp getById(Integer id);*/

    // 方案一: 给字段起别名，让别名与实体与属性一致
    // @Select("select id, username, password, name, gender, image, job, entrydate,
    // dept_id deptId, create_time createTime, update_time updateTime from emp where id=#{id}")
    // public Emp getById(Integer id);

    // 方案二: 通过@Results、@Result注解手动映射封装
    /*@Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);*/


    // 方案三: 开启MyBatis的驼峰命名自动映射开关
    // mybatis.configuration.map-underscore-to-camel-case=true
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);


    /**
     * 条件查询
     * 实现模糊查询name，精准查询gender，范围查询入职时间。
     * */
    // 这种方式并不好，%${name}%这样存在SQL注入的风险
    /*@Select("select * from emp " +
            "where name like '%${name}%' " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);*/

    // 改进条件查询，使用concat函数，解决SQL注入的风险，生成预编译的SQL
    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /*@Select("select * from emp")
    public List<Emp> list();*/

    // 批量删除
    // public void deleteByIds(List<Integer> ids);
}
