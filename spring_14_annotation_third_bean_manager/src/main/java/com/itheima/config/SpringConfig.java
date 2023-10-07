package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
//@ComponentScan("com.itheima.config")
@ComponentScan("com.itheima")
@Import({JdbcConfig.class})
public class SpringConfig {}
