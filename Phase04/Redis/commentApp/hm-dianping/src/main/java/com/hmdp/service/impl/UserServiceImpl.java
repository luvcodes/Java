package com.hmdp.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
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
}
