package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ryanw
 */
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc放行前逻辑");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Abc放行后逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
