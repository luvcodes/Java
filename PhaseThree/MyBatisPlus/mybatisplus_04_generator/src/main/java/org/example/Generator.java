package org.example;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * @author ryanw
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatisplus-db?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        generator.setDataSource(dataSource);

        generator.execute();
    }
}
