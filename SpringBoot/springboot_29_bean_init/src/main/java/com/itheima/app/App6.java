package com.itheima.app;

import com.itheima.bean.Cat;
import com.itheima.bean.Mouse;
import com.itheima.config.SpringConfig4;
import com.itheima.config.SpringConfig6;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App6 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig6.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------");
    }
}
