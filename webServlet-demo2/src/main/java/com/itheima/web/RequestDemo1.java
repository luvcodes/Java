package com.itheima.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod() 获取请求方式: GET
        String method = req.getMethod();
        System.out.println(method);
        // String getContextPath() 获取虚拟目录(项目访问路径)
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // StringBuffer getRequestURL() 获取URL(统一资源标识符)
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        // String getRequestURI() 获取URI(统一资源标识符)
        String uri = req.getRequestURI();
        System.out.println(uri);
        // String getQueryString() 获取请求参数(GET方式)
        String queryString = req.getQueryString();
        System.out.println(queryString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
