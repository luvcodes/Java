package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author ryanw
 */
@Data
public class User {
//    @TableId(type = IdType.AUTO)
//    @TableId(type = IdType.INPUT)
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;

    // select=false 不查询特定的字段
    @TableField(value = "pwd", select = false)
    private String password;

    private Integer age;
    private String tel;

    // 这里是为了在代码中添加了属性，但是数据库中没有的情况
    @TableField(exist = false)
    private Integer online;

    // 逻辑删除字段，标记当前记录是否被删除
//    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    // 乐观锁
    @Version
    private Integer version;
}
