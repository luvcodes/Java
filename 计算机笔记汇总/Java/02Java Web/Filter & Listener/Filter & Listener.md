# Filter

概念: Filter表示过滤器，是JavaWeb三大组件 (Servlet，Filter，Listener) 之一。

过滤器可以把对资源的请求拦截下来。过滤器（Filter）是Java Web中的一个重要组件，它可以在请求到达目标Servlet之前，以及从Servlet返回给客户端之后，对请求或响应进行一些处理。过滤器有许多应用场景，例如：

# Filter执行流程

过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能。使用了过滤器之后，要想访问web服务器上的资源，必须先经过滤器，过滤器处理完毕之后，才可以访问对应的资源。

![[/Untitled 8.png|Untitled 8.png]]

过滤器当中我们拦截到了请求之后，如果希望继续访问后面的web资源，就要执行放行操作，放行就是调用 FilterChain对象当中的doFilter()方法，在调用doFilter()这个方法之前所编写的代码属于放行之前的逻辑。

在放行后访问完 web 资源之后还会回到过滤器当中，回到过滤器之后如有需求还可以执行放行之后的逻辑，放行之后的逻辑我们写在doFilter()这行代码之后。

## **Filter快速入门**

1. 定义类，实现Filter接口，并重写其所有方法
2. 配置Filter拦截资源的路径: 在类上定义`@WebFIlter`注解
3. 在doFilter方法中输出一句话，并放行

# Filter使用细节

## Filter拦截路径配置

Filter可以根据需求，配置不同的拦截资源路径：

|   |   |   |
|---|---|---|
|拦截路径|urlPatterns值|含义|
|拦截具体路径|/login|只有访问 /login 路径时，才会被拦截|
|目录拦截|/emps/*|访问/emps下的所有资源，都会被拦截|
|拦截所有|/*|访问所有资源，都会被拦截|

## 过滤器链

所谓过滤器链指的是在一个web应用程序当中，可以配置多个过滤器，多个过滤器就形成了一个过滤器链。

![[/Untitled 1 2.png|Untitled 1 2.png]]

比如：在我们web服务器当中，定义了两个过滤器，这两个过滤器就形成了一个过滤器链。

### 实现方法

验证步骤：

1. 在filter包下再来新建一个Filter过滤器类：AbcFilter
2. 在AbcFilter过滤器中编写放行前和放行后逻辑
3. 配置AbcFilter过滤器拦截请求路径为：/ *
4. 重启SpringBoot服务，查看DemoFilter、AbcFilter的执行日志

AbcFilter过滤器

```Java
@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Abc 拦截到了请求... 放行前逻辑");

        //放行
        chain.doFilter(request,response);

        System.out.println("Abc 拦截到了请求... 放行后逻辑");
    }
}
```

DemoFilter过滤器

```Java
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoFilter   放行前逻辑.....");

        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("DemoFilter   放行后逻辑.....");
    }
}
```

打开浏览器访问登录接口：

![[/Untitled 2 3.png|Untitled 2 3.png]]

通过控制台日志的输出，大家发现AbcFilter先执行DemoFilter后执行，这是为什么呢？

**其实是和过滤器的类名有关系**。以注解方式配置的Filter过滤器，它的**执行优先级是按时过滤器类名的自动排序确定的，类名排名越靠前，优先级越高**。

  

**假如我们想让DemoFilter先执行，怎么办呢？答案就是修改类名。**

测试：修改AbcFilter类名为XbcFilter，运行程序查看控制台日志

```Java
@WebFilter(urlPatterns = "/*")
public class XbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Xbc 拦截到了请求...放行前逻辑");

        //放行
        chain.doFilter(request,response);

        System.out.println("Xbc 拦截到了请求...放行后逻辑");
    }
}
```

![[/Untitled 3 3.png|Untitled 3 3.png]]

# Listener

- 概念: Listener表示监听器，是JavaWeb三大组件 (Servlet, Filter, Listener)之一
- 监听器可以监听就是在application，session，request三个对象创建，销毁或者往其中添加修改删除属性时自动执行代码的功能组件
- Listener分类，JaveWeb中提供了8个监听器

## ServletContextListener的使用

1. 定义类，实现ServletContextListener接口
2. 在类上添加@WebListener注解

## Listener优先于filter？

在JavaWeb应用程序中，监听器（Listener）通常在应用程序启动时初始化，并在过滤器和Servlet之前执行。这是因为监听器主要用于监听和响应Web应用程序生命周期事件，例如应用程序的启动和关闭，会话的创建和销毁等。

而过滤器（Filter）则主要用于处理HTTP请求和响应。当一个HTTP请求到达Web应用程序时，过滤器会在请求被Servlet（或JSP）处理之前和之后执行。

因此，监听器的contextInitialized方法会在过滤器和Servlet处理请求之前执行，而contextDestroyed方法则会在应用程序关闭时执行，这时所有的请求都已经处理完毕。希望这个解释对你有所帮助！

# 为什么需要使用Filter和Listener？

1. **解耦**: 通过使用 Filter 和 Listener，可以将一些非业务逻辑（如安全检查、日志记录等）与实际的业务逻辑解耦。
2. **代码重用**: 一些通用的功能（如字符集设置、权限检查等）可以封装在 Filter 或 Listener 中，以便在多个地方重用。
3. **维护性**: 使用 Filter 和 Listener 可以使代码更加模块化，从而更容易维护。
4. **灵活性**: 可以轻松地添加或删除 Filter 和 Listener，而不影响其他代码。
5. **性能优化**: 通过合理地使用 Filter 和 Listener，可以进行一些性能优化，如缓存。

因此，合理地使用 Filter 和 Listener 可以使 Web 应用更加模块化、可维护和高效。