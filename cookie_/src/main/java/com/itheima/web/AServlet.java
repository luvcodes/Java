package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 发送cookie

        // 1. 创建cookie对象
        Cookie cookie = new Cookie("username", "zs");

        // 2. 发送cookie
        resp.addCookie(cookie);

        // 3. 获取客户端携带的所有Cookie，使用request对象


        // 4. 遍历数组，获取每一个Cookie对象


        // 5. 使用Cookie对象方法获取数据


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
