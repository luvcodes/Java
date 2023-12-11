package com.itheima.service.impl;

import com.itheima.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl2 implements BookService {

    @Override
    public void check() {
        System.out.println("Book Service 2 ..");
    }
}
