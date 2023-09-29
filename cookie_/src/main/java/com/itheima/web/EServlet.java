package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 中文解码
 * */
@WebServlet("/eServlet")
public class EServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3. 获取客户端携带的所有Cookie，使用request对象
        Cookie[] cookies = req.getCookies();

        // 4. 遍历数组，获取每一个Cookie对象
        for (Cookie cookie : cookies) {
            // 5. 使用Cookie对象方法获取数据
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                // URL解码
                value = URLDecoder.decode(value, "UTF-8");

                System.out.println(name + " : " + value);

                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
