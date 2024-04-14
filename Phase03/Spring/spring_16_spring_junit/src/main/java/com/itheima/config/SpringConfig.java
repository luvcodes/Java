package com.itheima.config;

import com.itheima.dao.AccountDao;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
