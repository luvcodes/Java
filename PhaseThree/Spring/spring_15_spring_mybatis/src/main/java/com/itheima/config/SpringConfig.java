package com.itheima.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.itheima")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@MapperScan("com.itheima.dao")
public class SpringConfig {}
