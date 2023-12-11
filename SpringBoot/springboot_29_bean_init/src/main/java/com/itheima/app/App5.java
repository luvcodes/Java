package com.itheima.app;

import com.itheima.bean.Cat;
import com.itheima.bean.Dog;
import com.itheima.bean.Mouse;
import com.itheima.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig4.class);
        // 上下文容器对象已经初始化完毕后，不使用配置类，手工加载bean
        context.registerBean("tom", Cat.class, 0);
        context.registerBean("tom", Cat.class, 1);
        context.registerBean("tom", Cat.class, 2);

        context.register(Mouse.class); // 这里如果注释掉Mouse类的@Servie，结果就是输出mouse

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------");
        // 通过这种手工注册的方式就相当于是一个map，最后一个留下来了。这是由于Cat类中设置了构造器
        System.out.println(context.getBean(Cat.class));
    }
}
