package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
//@TableName("tbl_user") // 这里是为了如果表名改了，这里可以匹配上
public class User {
    private Long id;
    private String name;
//    @TableField(value = "pwd") // 这里是为了如果表中字段名改了，这里可以匹配上
    private String password;
    private Integer age;
    private String tel;

    // 这里是为了在代码中添加了属性，但是数据库中没有的情况
//    @TableField(exist = false)
//    private Integer online;
}
