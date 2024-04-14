package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 这是为了和DemoFilter进行配合，体现过滤器链
 * @author ryanw
 */
//@WebFilter(urlPatterns = "/*")
public class abcFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init method called for the abcFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前逻辑...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行后逻辑...");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method called for the abcFilter");
    }
}
