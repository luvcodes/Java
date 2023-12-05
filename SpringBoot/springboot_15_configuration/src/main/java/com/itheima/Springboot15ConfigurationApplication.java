package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class) // 这样的方法是外部注入，替代@Component注解
public class Springboot15ConfigurationApplication {
    @Bean
    @ConfigurationProperties(prefix = "datasource") // 这样的方法是外部注入，第二种方法
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        // 这样是手动配置，第一种方法
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
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
