# 什么是拦截器？

- 是一种动态拦截方法调用的机制，类似于过滤器。
- 拦截器是Spring框架中提供的，用来动态拦截控制器方法的执行。

# 拦截器的作用

- 拦截请求，在指定方法调用前后，根据业务需要执行预先设定的代码。

# 自定义拦截器

```Java
//自定义拦截器
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法执行前执行。 返回true：放行    返回false：不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle .... ");

        return true; //true表示放行
    }

    //目标资源方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ... ");
    }

    //视图渲染完毕后执行，最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion .... ");
    }
}
```

注意：

- preHandle方法：目标资源方法执行前执行。 返回true：放行 返回false：不放行
- postHandle方法：目标资源方法执行后执行
- afterCompletion方法：视图渲染完毕后执行，最后执行

## 注册配置拦截器

实现WebMvcConfigurer接口，并重写addInterceptors方法

```Java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //自定义的拦截器对象
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       //注册自定义拦截器对象
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
    }
}
```

# 拦截器详解

## 拦截路径

首先我们先来看拦截器的拦截路径的配置，在注册配置拦截器的时候，我们要指定拦截器的拦截路径，通过addPathPatterns("要拦截路径")方法，就可以指定要拦截哪些资源。

在入门程序中我们配置的是/**，表示拦截所有资源，而在配置拦截器时，不仅可以指定要拦截哪些资源，还可以指定不拦截哪些资源，只需要调用excludePathPatterns("不拦截路径")方法，指定哪些资源不需要拦截。

```Java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //拦截器对象
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器对象
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
                .excludePathPatterns("/login");//设置不拦截的请求路径
    }
}
```

在拦截器中除了可以设置/**拦截所有资源外，还有一些常见拦截路径设置：

|   |   |   |
|---|---|---|
|拦截路径|含义|举例|
|/*|一级路径|能匹配/depts，/emps，/login，不能匹配 /depts/1|
|/**|任意级路径|能匹配/depts，/depts/1，/depts/1/2|
|/depts/*|/depts下的一级路径|能匹配/depts/1，不能匹配/depts/1/2，/depts|
|/depts/**|/depts下的任意级路径|能匹配/depts，/depts/1，/depts/1/2，不能匹配/emps/1|

## 拦截器的执行流程

![[/Untitled 9.png|Untitled 9.png]]

  

- 当我们打开浏览器来访问部署在web服务器当中的web应用时，此时我们所定义的过滤器会拦截到这次请求。拦截到这次请求之后，它会先执行放行前的逻辑，然后再执行放行操作。而由于我们当前是基于springboot开发的，所以放行之后是进入到了spring的环境当中，也就是要来访问我们所定义的controller当中的接口方法。
- Tomcat并不识别所编写的Controller程序，但是它识别Servlet程序，所以在Spring的Web环境中提供了一个非常核心的Servlet：DispatcherServlet（前端控制器），所有请求都会先进行到DispatcherServlet，再将请求转给Controller。
- 当我们定义了拦截器后，会在执行Controller的方法之前，请求被拦截器拦截住。执行preHandle()方法，这个方法执行完成后需要返回一个布尔类型的值，如果返回true，就表示放行本次操作，才会继续访问controller中的方法；如果返回false，则不会放行（controller中的方法也不会执行）。
- 在controller当中的方法执行完毕之后，再回过来执行postHandle()这个方法以及afterCompletion() 方法，然后再返回给DispatcherServlet，最终再来执行过滤器当中放行后的这一部分逻辑的逻辑。执行完毕之后，最终给浏览器响应数据。

# 过滤器和拦截器之间的区别

- 接口规范不同：过滤器需要实现Filter接口，而拦截器需要实现HandlerInterceptor接口。
- 拦截范围不同：过滤器Filter会拦截所有的资源，而Interceptor只会拦截Spring环境中的资源。