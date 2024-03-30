package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ryanw
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("用户登录 {}", emp);
        // 调用业务层：登录功能
        Emp e = empService.login(emp);
        // 判断: 登录用户是否存在
        if (e != null) {
            // 自定义信息
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());

            // 使用JWT工具类，生成身份令牌
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }
}
