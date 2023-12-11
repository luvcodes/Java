package com.itheima.app;

import com.itheima.config.SpringConfig32;
import com.itheima.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App33 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig33.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        SpringConfig33 config = context.getBean("springConfig33", SpringConfig33.class);
        System.out.println(config);
        System.out.println(config.cat());
        System.out.println(config.cat());
        System.out.println(config.cat());

    }
}
