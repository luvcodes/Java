MyBatis用来管SqlSessionFactory对象

# SpringConfig

```Java
@Configuration
@ComponentScan("com.itheima")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {}
```

这四个注解都是Spring框架中用于配置和组织代码的注解。

1. `**@Configuration**`:

- `@Configuration`注解标记一个类作为Bean定义的源。简单地说，它告诉Spring框架，该类包含了应用程序上下文的bean定义。

1. `**@ComponentScan**`:

- `@ComponentScan`注解告诉Spring从哪里扫描组件。它会自动扫描指定包及其子包，并识别和注册Bean，例如`@Component`、`@Service`、`@Repository`和`@Controller`等。
- 在你给的例子中，`@ComponentScan("com.itheima")`表示Spring应该从`com.itheima`包开始扫描。

1. `**@PropertySource**`:

- `@PropertySource`注解用于指定**属性文件**的位置，这些属性文件将被加载到Spring的Environment中。这样，你可以在应用程序中通过Spring的`Environment`接口或`@Value`注解来访问这些属性。

1. `**@Import**`:

- `@Import`注解允许你导入其他**配置类**，将它们合并到当前的配置类中。这样可以帮助你模块化配置，并保持配置的清晰和组织。

# MyBatisConfig

本来这个MyBatis的配置文件应该是这样

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <properties resource="jdbc.properties"></properties>
  <!-- 初始化类型别名 -->
  <typeAliases>
    <package name="com.com.itheima.domain"/>
  </typeAliases>
  <!-- 初始化dataSource -->
  <environments default="mysql">
    <environment id="mysql">
      <transactionManager type="JDBC"></transactionManager>
      <dataSource type="POOLED">
        <property name="driver" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
      </dataSource>
    </environment>
  </environments>
  <!-- 初始化映射配置 -->
  <mappers>
    <package name="com.com.itheima.dao"></package>
  </mappers>
</configuration>
```

```Java
package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml.bak");
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 获取SqlSession，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5. 执行SqlSession对象执行查询，获取结果User
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        Account ac = accountDao.findById(1);
        System.out.println(ac);

        // 释放资源
        sqlSession.close();
    }
}
```

但是现在有了下面这种方式，就可以不需要上面这个SqlMapConfig.xml文件了

```Java
package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.com.itheima.domain");
        ssfb.setDataSource(dataSource);

        return ssfb;
    }

    // 这里是为了SqlMapConfig配置文件中的mapper标签
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.com.itheima.dao");
        return mapperScannerConfigurer;
    }
}
```

这段代码是一个简单的 MyBatis 配置类，用于配置 MyBatis 的相关组件以实现数据库访问。

1. **SqlSessionFactoryBean 配置：**

```Java
@Bean
public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
    SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
    ssfb.setTypeAliasesPackage("com.com.itheima.domain");
    ssfb.setDataSource(dataSource);

    return ssfb;
}
```

- `SqlSessionFactoryBean` 是 Spring 提供的用于配置 MyBatis 的工厂bean，它包含了 MyBatis 的配置信息，并生成 `SqlSessionFactory` 实例，用于创建 `SqlSession`。
- `dataSource` 参数是通过依赖注入注入的数据源，表示配置 MyBatis 使用的数据库。
- `setTypeAliasesPackage("com.com.itheima.domain")` 指定了 MyBatis 在扫描别名时的包路径，这里是指定了实体类的包路径。

1. **MapperScannerConfigurer 配置：**

```Java
public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setBasePackage("com.com.itheima.dao");
    return mapperScannerConfigurer;
}
```

- `MapperScannerConfigurer` 是用于配置 MyBatis 的 Mapper 接口扫描器，它会自动扫描指定包路径下的接口，并将它们注册为 MyBatis 的 Mapper。
- `setBasePackage("com.com.itheima.dao")` 指定了扫描 Mapper 接口的包路径。

这个配置类的目的是将 MyBatis 和 Spring 整合，配置 MyBatis 的核心组件，包括 `SqlSessionFactory` 和 Mapper 接口扫描器，以便在 Spring 容器中使用 MyBatis 进行数据库操作。需要注意的是，这里的配置类缺少 `@Configuration` 注解，如果打算使用 Java 配置的方式，需要确保这个类被正确地注册到 Spring 容器中。

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701505829964-55a09502-9fe6-4726-acec-627a1856f70f.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701505829964-55a09502-9fe6-4726-acec-627a1856f70f.png)

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701505862421-c6a9b6bc-9136-4740-9bdb-845be8e98d93.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1701505862421-c6a9b6bc-9136-4740-9bdb-845be8e98d93.png)

# Mapper

在 MyBatis 中，`Mapper` 通常指的是用于定义数据访问操作的接口。这些接口定义了与数据库交互的方法，例如插入、更新、删除和查询数据等。每个 `Mapper` 接口对应着一个或多个与之相关联的 SQL 语句。

在 MyBatis 中，`Mapper` 接口的方法与映射文件（XML 文件或者注解）中定义的 SQL 语句相对应。通过 `Mapper` 接口，你可以在 Java 代码中调用这些方法，而 MyBatis 将负责执行相应的 SQL 操作。

通常，`Mapper` 接口的实现是由 MyBatis 在运行时动态生成的。开发人员只需要编写接口，而 MyBatis 将会为这些接口创建代理对象，实现接口中定义的方法。这种方式使得数据访问层的开发更加简洁，同时也提供了更好的灵活性。

以下是一个简单的示例，展示了一个 `UserMapper` 接口：

```Java
public interface UserMapper {
    User getUserById(int userId);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
```

这里的 `UserMapper` 接口定义了一些基本的数据访问方法，例如根据用户ID获取用户、插入用户、更新用户信息和删除用户。具体的 SQL 语句将在映射文件或注解中进行定义。在应用程序中，你可以注入 `UserMapper` 接口的实例，并调用这些方法来执行相应的数据库操作。