package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ryanw
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 1. 获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url: {}", url);

        // 2. 判断请求url中是否包含login，如果包含，说明是登陆操作，放行
        if (url.contains("login")) {
            log.info("登陆操作, 放行。。。");
            filterChain.doFilter(req, resp);
            return;
        }

        // 3. 获取请求头中的令牌
        String jwt = req.getHeader("token");

        // 4. 判断令牌是否存在，如果不存在，返回错误结果 (未登录)
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象 -> JSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5. 解析token，如果解析失败，返回错误结果 (未登录)
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("登陆失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象 -> JSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
