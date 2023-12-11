package com.itheima.config;

import com.itheima.bean.Dog;
import com.itheima.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.itheima.config", "com.itheima.bean"})
public class SpringConfig {

    @Bean
    public DogFactoryBean dog() {
        return new DogFactoryBean();
    }
}
