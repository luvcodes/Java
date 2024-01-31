package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.bean.Cat;
import com.itheima.bean.Mouse;
import com.itheima.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@Import(MyImportSelector.class)
@Import(Mouse.class)
@ComponentScan("com.itheima.bean")
public class SpringConfig {

//    @Bean
////    @ConditionalOnClass(name = "com.itheima.bean.Mouse')
////    @ConditionalOnMissingClass("com.itheima.bean.Mouse")
//    @ConditionalOnBean(name = "jerry") // 只抓jerry
////    @ConditionalOnMissingClass("com.itheima.bean.Dog")
////    @ConditionalOnNotWebApplication
//    @ConditionalOnWebApplication // 看是不是Web项目
//    public Cat tom() {
//        return new Cat();
//    }

    /**
     * 下面这样如果我在POM中没有添加MySQL，下面这段是不运行的
     * 所以相当于判断如果用这个技术，里面的内容就写好了，如果没写好，那么就用下面的方法
     * */
    @Bean
    @ConditionalOnClass(name = "com.mysql.jdbc.Driver")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
