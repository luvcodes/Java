package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author ryanw
 */
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    /**
     * 拦截到请求之后调用多次
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                System.out.println("Demo 放行前逻辑");
                // 放行
                chain.doFilter(request, response);

                System.out.println("Demo 放行后逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }

}
