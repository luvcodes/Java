package com.hmall.domain.vo;

import lombok.Data;

/**
 * @author ryanw
 */
@Data
public class UserLoginVO {
    private String token;
    private Long userId;
    private String username;
    private Integer balance;
}
