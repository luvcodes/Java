package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ryanw
 */
public interface UserMapper {
    // 如果查很多个就是List，一个就是User对象即可
    // 这里selectAll对应的是sql语句的id
    List<User> selectAll();

    User selectById(int id);

    /**
     * MyBatis参数传递:
     *  单个参数:
     * </p>
     *  多个参数:
     * </p>
     * */
    User select(@Param("username") String username, @Param("password") String password);

    @Select(("select * from tb_user where id = #{id}"))
    User selectByIdAnnotation(int id);
}
