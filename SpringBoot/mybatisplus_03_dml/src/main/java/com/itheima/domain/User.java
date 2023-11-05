package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

@Data
//@TableName("tbl_user") // 这里是为了如果表名改了，这里可以匹配上
public class User {
//    @TableId(type = IdType.AUTO)
//    @TableId(type = IdType.INPUT)
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(value = "pwd", select = false) // 这里是为了如果表中字段名改了，这里可以匹配上
    private String password;
    private Integer age;
    private String tel;
    // 这里是为了在代码中添加了属性，但是数据库中没有的情况
    @TableField(exist = false)
    private Integer online;
    // 逻辑删除字段，标记当前记录是否被删除
//    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    @Version // 乐观锁
    private Integer version;
}
