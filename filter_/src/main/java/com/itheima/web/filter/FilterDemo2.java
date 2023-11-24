package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// @WebFilter("/hello.jsp")
@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 放行前，对request数据进行处理
        System.out.println("2. Filter demo...");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        // 2. 放行后，对Response数据进行处理
        System.out.println("3. Filter demo...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
