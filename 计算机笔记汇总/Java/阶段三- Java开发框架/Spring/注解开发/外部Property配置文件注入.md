## 注入单个配置文件

`@PropertySource("配置文件名")`

```Java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("jdbc.properties")
public class SpringConfig {}
```

```Java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    // 配置引用数据类型。用的是下面的配置文件的代码
    @Value("${name}")
    private String name;

    @Override
    public void save() {
        System.out.println("book dao save..." + name);
    }
}
```

```Java
name=itheima
```

## 注入多个配置文件

```Java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
@PropertySource({"jdbc.properties", "jdbc2.properties", "jdbc3.properties"})
public class SpringConfig {}
```