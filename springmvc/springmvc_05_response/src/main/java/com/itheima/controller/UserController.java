package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/toJumpPage")
    public String toJumpPage() {
        System.out.println("Jump page");
        return "page.jsp";
    }

    @RequestMapping("/toText")
    @ResponseBody
    public String toText() {
        System.out.println("Jump page");
        return "response text";
    }

    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO() {
        System.out.println("Return json object data");
        User user = new User();
        user.setName("itcast");
        user.setAge(15);
        return user;
    }

    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList() {
        System.out.println("Return json object data");
        User user1 = new User();
        user1.setName("itcast");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("itcast");
        user2.setAge(15);

        User user3 = new User();
        user3.setName("itcast");
        user3.setAge(15);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
