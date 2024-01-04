package com.itheima.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 中文编码
 * */
@WebServlet("/dServlet")
public class DServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 发送cookie

        // 1. 创建cookie对象
//        Cookie cookie = new Cookie("username", "张三");

        String value = "张三";
        // URL编码
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据: " + value);

        Cookie cookie = new Cookie("username", value);

        // 设置存活时间
        cookie.setMaxAge(60*60*24*7); // 7天

        // 2. 发送cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
