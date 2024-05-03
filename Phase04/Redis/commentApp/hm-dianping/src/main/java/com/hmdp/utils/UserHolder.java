package com.hmdp.utils;

import com.hmdp.dto.UserDTO;

/**
 * @author ryanw
 * 这个类就是为了拦截器而使用的，为的是能够使User登录的时候保存到ThreadLocal中
 */
public class UserHolder {
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
