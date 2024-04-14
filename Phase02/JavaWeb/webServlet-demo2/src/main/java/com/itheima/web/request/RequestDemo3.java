package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码问题解决
 * 不管是用post还是get，不定义解决方法前，在终端看到的日志都会乱码
 * 针对req.setCharacterEncoding("UTF-8")的这一行代码，实际上是专门针对POST而实现的
 * 但是其实像第40行代码是一种通用的解决方法，同时可以满足GET和POST的需求。
 * </p>
 * 现在Tomcat8之后，已经将GET请求乱码问题解决，设置默认的解码方式为UTF-8
 * */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 解决乱码: POST, 通过getReader() 字符输入流的方式来获取数据
        // 设置字符输入流的编码
        req.setCharacterEncoding("UTF-8");

        // 2. 获取username
        String username = req.getParameter("username");
        System.out.println("解决乱码前: " + username);

        // 3. GET和POST的底层获取请求参数的方法不同，获取参数方式: getQueryString
        // 查看RequestDemo1文件的实现
        /**
         * 中文乱码原因: tomcat进行URL解码所使用的默认字符集为ISO-8859-1
         * 3.1 先对乱码数据进行编码: 转为字节数据
         * */
//        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
//        // 3.2 字节数组解码
//        username = new String(bytes, StandardCharsets.UTF_8);

//        // 这样写可以替换上面的两行代码
//        username = new String(username.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);

        System.out.println("解决乱码后: " + username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
