package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("get...");
    }

    @Override
    protected void doPost(HttpServletRequest request, ServletResponse servletResponse) {
        System.out.println("post...");
    }
}
