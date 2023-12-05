package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 获取BookDao bean 并调用save方法
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();

        // 获取DataSource bean
        DataSource dataSource = ctx.getBean(DataSource.class);

        // 打印DataSource属性
        if (dataSource instanceof DruidDataSource) {
            // 向下转型 DataSource是一个接口，而DruidDataSource是实现该接口的具体类
            DruidDataSource druidDataSource = (DruidDataSource) dataSource;
            System.out.println("DriverClassName: " + druidDataSource.getDriverClassName());
            System.out.println("URL: " + druidDataSource.getUrl());
            System.out.println("Username: " + druidDataSource.getUsername());
            System.out.println("Password: " + druidDataSource.getPassword());
            // 根据需要打印其他属性
        } else {
            System.out.println("DataSource不是DruidDataSource的实例。");
        }
    }
}
