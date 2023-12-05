package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot15ConfigurationApplication {
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/springboot_15_configuration");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
        return dataSource;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot15ConfigurationApplication.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        DruidDataSource druidDataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getDriverClassName());
    }
}
