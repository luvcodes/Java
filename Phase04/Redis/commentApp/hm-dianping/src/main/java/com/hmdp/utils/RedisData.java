package com.hmdp.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ryanw
 * 此类是为了解决缓存击穿中的逻辑过期的逻辑而定义
 */
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
