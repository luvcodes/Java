package com.itheima.service.impl;

import com.itheima.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService") //定义bean的id，如果不指定，默认为类名首字母小写，即bookService1
public class BookServiceImpl1 implements BookService {

    @Override
    public void check() {
        System.out.println("Book Service 1..");
    }
}
