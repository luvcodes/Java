# 创建步骤

导入坐标与Servlet坐标

创建SpringMVC控制器类

```Java
@Controller
public class UserController {
    @RequestMapping("/save") // 设置当前操作的访问路径
    @ResponseBody // 设置当前操作的返回值类型, 就是把返回的内容整体当作一个内容给到外面
    public String save() {
        System.out.println("user save...");
        return "{'module:'springmvc'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        System.out.println("user delete...");
        return "{'module:'springmvc'}";
    }
}
```

  

初始化SpringMVC环境，设定SpringMVC加载对应的bean

```Java
@Configuration
@ComponentScan("com.itheima.controller")
public class SpringMVCConfig {}
```

  

初始化Servlet容器，加载SpringMVC环境，设置SpringMVC技术处理的请求

```Java
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // 加载SpringMVC容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMVCConfig.class);
        return ctx;
    }

    // 设置哪些请求归属springMVC处理
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // 去掉了原始的中括号中的0，/的意思是所有请求都由springMVC处理
    }

    // 加载spring容器配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
```

# 注解说明

`@Controller`

类注解。在SpringMVC控制器类定义上方。用来设定SpringMVC的核心控制器bean。它是一个Spring MVC注解，它标识这个类是一个控制器类。控制器类负责处理来自用户的HTTP请求，并返回响应。

`@RequestMapping`

方法注解。SpringMVC控制器的**方法定义上方**。用来**设置当前控制器方法响应内容为当前返回值，无需解析**。@RequestMapping("/save") 注解告诉Spring MVC，这个方法应该处理所有发送到/save路径的请求。

`@ResponseBody`

注解表示**此方法的返回值应直接写入HTTP响应体**。