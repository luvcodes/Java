package com.itheima.mp.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.itheima.mp.enums.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ryanw
 */
@Data
@TableName(value = "user", autoResultMap = true)
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String phone;

    /**
     * 详细信息
     * 这里写这个JacksonHandler的目的是为了转换输出中的JSON格式，本来是比较难看的{"age": 24, "intro": "英文老师", "gender": "female"}
     * 通过定义JacksonHandler，然后开启映射注解autoResultMap = true
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private UserInfo info;

    /**
     * 使用状态（1正常 2冻结）
     */
    private UserStatus status;

    /**
     * 账户余额
     */
    private Integer balance;

    @TableField(value = "create_time", exist = true)
    private LocalDateTime createTime;

    @TableField(value = "update_time", exist = true)
    private LocalDateTime updateTime;
}
