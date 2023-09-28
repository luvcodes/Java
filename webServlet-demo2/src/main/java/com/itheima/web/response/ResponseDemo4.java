package com.itheima.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字节数据: 设置字符数据的响应体
 * */

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取文件
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\webServlet-demo2\\src\\main\\java\\com\\itheima\\web\\response\\wallhaven-2y3qrg.png");
        // 2. 获取response字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

//        // 3. 完成流的copy
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fileInputStream.read(bytes)) != -1) {
//            outputStream.write(bytes, 0, len);
//        }

//        fileInputStream.close();

        // 3. 完成流的copy
        IOUtils.copy(fileInputStream, outputStream);

        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
