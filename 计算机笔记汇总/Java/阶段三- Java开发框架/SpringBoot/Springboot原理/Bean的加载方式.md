# 8种bean的加载方式

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1702326914094-dcaae2a5-4b8d-4bcb-be91-181ef1897198.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1702326914094-dcaae2a5-4b8d-4bcb-be91-181ef1897198.png)

# ImportSelector接口

```Java
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

```Java
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.itheima.bean.Cat"};
    }
}
```

```Java
@Import(MyImportSelector.class)
public class SpringConfig {
}
```

输出结果:

```Plain
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.annotation.internalCommonAnnotationProcessor
org.springframework.context.event.internalEventListenerProcessor
org.springframework.context.event.internalEventListenerFactory
springConfig
tom
```

# 编程控制bean的加载

[![](https://cdn.nlark.com/yuque/0/2023/png/38953059/1702329130358-8284fe6f-3ede-4fa8-9def-176d57d542ad.png)](https://cdn.nlark.com/yuque/0/2023/png/38953059/1702329130358-8284fe6f-3ede-4fa8-9def-176d57d542ad.png)