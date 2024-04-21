# 使用@Bean配置第三方bean

就是使用`@Bean`，然后再定义一个方法就行了。

```Java
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }
}
```

但是这种方式不建议。

### 方式一: 导入式

使用独立的配置类管理第三方bean

```Java
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }
}
```

```Java
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
@Import({JdbcConfig.class})
public class SpringConfig {}
```

如果是多个配置文件，使用数组形式 `{JdbcConfig.class}`

### 方式二: 扫描式 - 不推荐

# 新定义的bean需要其他方法或数据

### 注入简单类型

```Java
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

   @Bean
   public DataSource dataSource() {
       DruidDataSource ds = new DruidDataSource();
       ds.setDriverClassName(driver);
       ds.setUrl(url);
       ds.setUsername(username);
       ds.setPassword(password);
       return ds;
   }
}
```

### 注入引用类型

```Java
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

    // 注入引用类型
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
```

主要是dataSource方法的形参 `BookDao bookDao`

引用类型注入只需要为bean定义方法设置形参即可，容器会根据类型自动装配对象。