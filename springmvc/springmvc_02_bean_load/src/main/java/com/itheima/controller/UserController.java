package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/save") // 设置当前操作的访问路径
    @ResponseBody // 设置当前操作的返回值类型, 就是把返回的内容整体当作一个内容给到外面
    public String save() {
        System.out.println("user save...");
        return "{'module:'springmvc'}";
    }

    @RequestMapping("/delete")
    public String delete() {
        System.out.println("user delete...");
        return "{'module:'springmvc'}";
    }
}
