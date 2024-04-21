# bean作用范围

```Java
@Scope("singleton")
public class BookDaoImpl implements BookDao {}
```

# bean生命周期

```Java
// 记得在pom.xml导入坐标
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@PostConstruct
public void init() {
    System.out.println("init...");
}
@PreDestroy
public void destroy() {
    System.out.println("destroy...");
}
```

```Java
public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        BookDao bookDao1 = ctx.getBean(BookDao.class);
        System.out.println(bookDao);
        System.out.println(bookDao1);
        ctx.close();
    }
```