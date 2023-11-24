package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("tbl_user")
public class User {
    private Long id;
    private String name;
    @TableField(value = "pwd", exist = true)
    private String password;
    private Integer age;
    private String tel;

}
