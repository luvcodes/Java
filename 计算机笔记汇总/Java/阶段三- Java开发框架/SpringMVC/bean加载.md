[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1697152838405-52db7bd2-ae49-42b7-ae1b-e6417d164398.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1697152838405-52db7bd2-ae49-42b7-ae1b-e6417d164398.png)

# SpringMVC中bean的加载相关知识

## `DispatcherServlet` 加载过程

- DispatcherServlet在启动时会加载applicationContext.xml配置文件,
- 创建Spring容器并加载bean。
- Spring容器默认会扫描配置文件中指定的包路径下的类,找出标注有@Controller注解的类,并注册为bean。
    - @Controller注解表示该类是一个控制器, DispatcherServlet会扫描这些类, 并在Spring容器中注册为bean。
- @RequestMapping注解用于映射URL到控制器类或方法。
- `DispatcherServlet` 接收到请求后,会根据@RequestMapping注解匹配到对应的控制器进行处理。
- @Autowired注解可以对类成员变量、方法及构造函数进行标注, 完成自动装配的工作。通过@Autowired注解, Spring可以在上下文中查找匹配的bean并注入。
- @Service注解用于标注业务层组件。@Service标注的类会被Spring扫描并注册为bean。
- @Repository注解用于标注数据访问组件, 即DAO组件。@Repository标注的类也会被Spring扫描并注册为bean。