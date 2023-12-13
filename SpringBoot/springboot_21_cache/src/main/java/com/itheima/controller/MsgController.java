package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("{tele}")
    public String getById(@PathVariable String tele) {
        return msgService.get(tele);
    }

    @PostMapping
    public Boolean check(String tele, String code) {
        return msgService.check(tele, code);
    }

}
