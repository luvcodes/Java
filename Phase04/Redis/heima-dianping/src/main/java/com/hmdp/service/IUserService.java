package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ryanw
 */
public interface IUserService extends IService<User> {

    /**
     * 发送手机验证码
     * 这里需要session是因为生成验证码之后把验证码保存到session当中
     */
    Result sendCode(String phone, HttpSession session);

    /**
     * 登录功能
     * @param loginForm 登录参数，包含手机号、验证码；或者手机号、密码
     * 需要session参数的原因就是因为要把登录信息存到session
     */
    Result login(LoginFormDTO loginForm, HttpSession session);
}
