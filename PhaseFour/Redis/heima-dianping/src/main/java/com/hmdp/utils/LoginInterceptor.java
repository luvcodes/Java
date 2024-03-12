package com.hmdp.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ryanw
 */
public class LoginInterceptor implements HandlerInterceptor {
    // 这里不能使用Resource注解，因为在MvcConfig的拦截器里new了LoginInterceptor
    // 所以就是说这个LoginInterceptor不是Spring管理的
    private StringRedisTemplate stringRedisTemplate;

    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取请求头中的token
        // authorization是前端代码中定义的请求头
        String token = request.getHeader("authorization");
        if (StrUtil.isBlank(token)) {
            // 用户不存在，拦截 返回401状态码
            response.setStatus(401);
            return false;
        }
        // 2. 基于token获取redis中的用户
        // 使用Hash存储，所以用entries方法返回的就是Map
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash()
                .entries(RedisConstants.LOGIN_USER_KEY + token);
        // 3. 判断用户是否存在
        if (userMap.isEmpty()) {
            // 4. 用户不存在，拦截 返回401状态码
            response.setStatus(401);
            return false;
        }
        // 5. 将查询到的Hash数据转为UserDTO对象
        UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);

        // 6. 用户存在，保存用户信息到ThreadLocal
        UserHolder.saveUser(userDTO);

        // 7. 刷新token有效期
        stringRedisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);

        // 8. 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除用户
        UserHolder.removeUser();
    }
}
