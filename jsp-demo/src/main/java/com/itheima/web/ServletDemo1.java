package com.itheima.web;

import com.itheima.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 准备数据
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "三只松鼠", "三只松鼠", 100, "三只松鼠，好吃不上火", 1));
        brands.add(new Brand(2, "优衣库", "优衣库", 10, "优衣库，服饰人生", 0));
        brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));

        // 2. 存储到req域中
        req.setAttribute("brands", brands);

        // 3. 转发到el-demo.jsp
        req.getRequestDispatcher("/el-demo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
