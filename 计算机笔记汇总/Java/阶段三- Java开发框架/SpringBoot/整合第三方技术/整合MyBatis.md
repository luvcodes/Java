## **设置数据源参数**

```YAML
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
    username: root
    password: 123456
```

## **定义数据层接口与映射配置**

```Java
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    public Book getBookById(Integer id);
}
```

在Java的Spring框架和MyBatis集成中，`@Mapper` 注解用于标记一个接口作为MyBatis的映射接口。该注解告诉Spring Boot应用，这个接口是一个MyBatis Mapper，需要动态生成相应的代理类**以实现数据库操作**。

当你在接口上添加了 `@Mapper` 注解，Spring Boot在启动时会自动扫描到这个接口，并创建其代理对象，然后你就可以在Service中通过依赖注入（DI）的方式使用它。

`@Select` 是另一个MyBatis的注解，它用于执行SQL查询语句。在这个例子中，`@Select("select * from tbl_book where id = #{id}")`表示执行对应的SQL查询，并且将结果映射到Book对象。

## **测试类中注入dao接口，测试功能**

```Java
@SpringBootTest
class Springboot08MybatisApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        Book book = bookDao.getBookById(1);
        System.out.println(book);
    }
}
```