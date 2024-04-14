package com.itheima.config;

import com.itheima.bean.Cat;
import com.itheima.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import(Dog.class)
public class SpringConfig4 {
}
