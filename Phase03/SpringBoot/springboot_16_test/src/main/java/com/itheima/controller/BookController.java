package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.domain.Book;

@RestController
@RequestMapping("/books")
public class BookController {
//    @GetMapping
//    public String getById(){
//        System.out.println("getbyid is running");
//        return "springboot";
//    }

    @GetMapping
    public Book getBookById(){
        System.out.println("getbyid is running");

        Book book = new Book();
        book.setId(1);
        book.setName("Spring Boot");
        book.setType("IT");
        book.setDescription("SpringBoot开发");

        return book;
    }
}
