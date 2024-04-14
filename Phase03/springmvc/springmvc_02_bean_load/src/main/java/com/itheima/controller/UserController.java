package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
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
