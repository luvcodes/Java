package com.itheima.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    /**
     * 在doGet和doPost方法里实际上就是获取请求参数的这一行是不一样的，其他的部份基本都是一样的，
     * 所以可以有一个方法，实现简化代码，想要达到这一点，必须要做到get和post的请求方式统一。
     * </p>
     * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("get...");
        // 1. 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.print(key + ":");
            // 获取值
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        // 2. 根据key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        // 3. 根据key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

//        System.out.println("post...");
//        // 1. 获取所有参数的map集合
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (String key : parameterMap.keySet()) {
//            System.out.print(key + ":");
//            // 获取值
//            String[] values = parameterMap.get(key);
//            for (String value : values) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("--------------------------------");
//
//        // 2. 根据key获取参数值，数组
//        String[] hobbies = req.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
//
//        // 3. 根据key 获取单个参数值
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
    }
}
