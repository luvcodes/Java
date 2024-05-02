package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 第一个实现
     * 发送短信验证码
     * */
    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1. 校验手机号, 使用正则表达式来实现
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 2. 如果前端提交的手机号(phone)和校验的结果不符合，返回错误信息
            return Result.fail("手机号格式错误");
        }

        // 3. 如果符合，先生成验证码
        String code = RandomUtil.randomNumbers(6);

        // 4. 保存验证码到session中
        session.setAttribute("code", code);

        // 5. 发送验证码
        log.debug("发送短信验证码成功: {}", code);

        // 返回ok
        return Result.ok();
    }

    /**
     * 第二个实现的方法
     * 短信验证码登录、注册
     * */
    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        // 1. 校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            // 1.1 手机号不符合，返回错误信息
            return Result.fail("手机号格式错误");
        }

        // 2. 校验验证码
        Object sessionCode = session.getAttribute("code");
        String code = loginForm.getCode();
        // 2.1 sessionCode == null意思就是session中没有验证码，说明还没有发送验证码
        if (sessionCode == null || !sessionCode.toString().equals(code)) {
            // 3. 验证码不一致，报错
            return Result.fail("验证码错误");
        }

        // 4. 验证码一致，根据手机号查询用户
        User user = query().eq("phone", phone).one();

        // 5. 判断用户是否存在
        if (user == null) {
            // 6. 如果用户不存在，创建新用户并保存
            user = createUserWithPhone(phone);
        }

        // 7. 如果用户存在，保存用户信息UserDTO到session中
        session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));

        // 返回
        return Result.ok();
    }

    private User createUserWithPhone(String phone) {
        // 1. 创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        // 2. 保存用户
        save(user);

        return user;
    }
}
