package com.itheima.config;

import com.itheima.bean.MyRegistrar;
import com.itheima.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({MyRegistrar.class, BookServiceImpl1.class})
public class SpringConfig8 {
}
