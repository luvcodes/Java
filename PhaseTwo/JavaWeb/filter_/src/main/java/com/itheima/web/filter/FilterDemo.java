package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 放行前，对request数据进行处理
        System.out.println("1. Filter demo...");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        // 2. 放行后，对Response数据进行处理
        System.out.println("4. Filter demo...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
