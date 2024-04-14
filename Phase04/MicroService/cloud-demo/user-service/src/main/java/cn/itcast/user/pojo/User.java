package cn.itcast.user.pojo;

import lombok.Data;

/**
 * @author ryanw
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}