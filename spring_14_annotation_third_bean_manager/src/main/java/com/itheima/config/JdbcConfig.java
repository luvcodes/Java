package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.dao.impl.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {
    // 注入简单类型
    @Value("com.mysql.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring_db")
    private String url;
    @Value("root")
    private String username;
    @Value("123456")
    private String password;

    // 定义一个方法获得要管理的对象
    // 添加@Bean标识当前方法的返回值是一个bean
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName(driver);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }

    // 注入引用类型, 就通过参数bookDao来实现
    @Bean
    public DataSource dataSource(BookDao bookDao) {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
