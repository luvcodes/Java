package org.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ryanw
 */
@Data
@TableName("members")
public class Member {
    @TableId(type = IdType.AUTO) // 如果需要指定ID类型
    private Integer id;
    private String username;
    private String email;
    @TableField("joined_at")
    private Long joinedAt;
}
