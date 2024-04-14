package com.itheima.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字符数据: 设置字符数据的响应体
 * */

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取字符输出流
        PrintWriter writer = resp.getWriter();
        // content-type
        // resp.setHeader("content-type", "text/html");

        writer.write("aaa");
        writer.write("<h1>aaa</h1>");
        // 这里如果传进去的string是中文会出现乱码, 所以需要开头的那一行charset设置
        writer.write("你好");


        // 细节: 流不需要关闭

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
