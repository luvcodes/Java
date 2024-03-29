package com.itheima.web.servletBasics;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ryanw
 */
public class MyHttpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 根据请求方式的不同，进行分别的处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1. 获取请求方式
        String method = request.getMethod();
        // 2. 判断
        if ("GET".equals(method)) {
            // GET方式的处理逻辑
            doGet(request, servletResponse);

        } else if ("POST".equals(method)) {
            // POST方式的处理逻辑
            doPost(request, servletResponse);
        }
    }

    protected void doPost(HttpServletRequest request, ServletResponse servletResponse) {
    }

    protected void doGet(HttpServletRequest request, ServletResponse servletResponse) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
