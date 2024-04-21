# 核心概念

概念: AOP面向切面编程，一种编程范式

作用: AOP面向方法编程，就可以做到在不改动这些原始方法的基础上，针对特定的方法进行功能的增强。

## 连接点：JoinPoint

可以被AOP控制的方法（暗含方法执行时的相关信息）

连接点指的是可以被aop控制的方法。例如：入门程序当中所有的业务方法都是可以被aop控制的方法。

![[/Untitled 22.png|Untitled 22.png]]

在SpringAOP提供的JoinPoint当中，封装了连接点方法在执行时的相关信息。（后面会有具体的讲解）

## 通知：Advice

指那些重复的逻辑，也就是共性功能（最终体现为一个方法）

在入门程序中是需要统计各个业务方法的执行耗时的，此时我们就需要在这些业务方法运行开始之前，先记录这个方法运行的开始时间，在每一个业务方法运行结束的时候，再来记录这个方法运行的结束时间。

但是在AOP面向切面编程当中，我们只需要将这部分重复的代码逻辑抽取出来单独定义。抽取出来的这一部分重复的逻辑，也就是共性的功能。

![[/Untitled 1 8.png|Untitled 1 8.png]]

  

## 切入点：PointCut

匹配连接点的条件，通知仅会在切入点方法执行时被应用

在通知当中，我们所定义的共性功能到底要应用在哪些方法上？此时就涉及到了切入点pointcut概念。切入点指的是匹配连接点的条件。通知仅会在切入点方法运行时才会被应用。

在aop的开发当中，我们通常会通过一个切入点表达式来描述切入点(后面会有详解)。

![[/Untitled 2 8.png|Untitled 2 8.png]]

  

假如：切入点表达式改为DeptServiceImpl.list()，此时就代表仅仅只有list这一个方法是切入点。只有list()方法在运行的时候才会应用通知。

## **切面：Aspect**

描述通知与切入点的对应关系（**通知+切入点**）

当通知和切入点结合在一起，就形成了一个切面。通过切面就能够描述当前aop程序需要针对于哪个原始方法，在什么时候执行什么样的操作。

![[/Untitled 3 5.png|Untitled 3 5.png]]

**切面所在的类，我们一般称为切面类**（被@Aspect注解标识的类）

  

## **目标对象：Target**

通知所应用的对象

目标对象指的就是通知所应用的对象，我们就称之为目标对象。

![[/Untitled 4 3.png|Untitled 4 3.png]]

  

# AOP工作流程

1. Spring容器启动
2. 读取所有切面配置中的切入点
3. 初始化bean，判定bean对应的类中的方法是否匹配到任意切入点
4. 匹配失败，创建对象
5. 匹配成功，创建原始对象 (目标对象) 的代理对象
6. 获取bean执行方法
7. 获取bean，调用方法并执行，完成操作
8. 获取的bean是代理对象时，根据代理对象的运行模式运行原始方法与增强的内容，完成操作

# AOP进阶

## AOP通知类型 - 5种

- @Around：环绕通知，此注解标注的通知方法在目标方法前、后都被执行
- @Before：前置通知，此注解标注的通知方法在目标方法前被执行
- @After ：后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
- @AfterReturning ： 返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
- @AfterThrowing ： 异常后通知，此注解标注的通知方法发生异常后执行

  

```Java
@Slf4j
@Component
@Aspect
public class MyAspect1 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before ...");

    }

    //环绕通知
    @Around("execution(* com.itheima.service.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();
    
        //原始方法如果执行时有异常，环绕通知中的后置代码不会在执行了
    
        log.info("around after ...");
        return result;
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        log.info("after ...");
    }

    //返回后通知（程序在正常执行的情况下，会执行的后置通知）
    @AfterReturning("execution(* com.itheima.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning ...");
    }

    //异常通知（程序在出现异常的情况下，执行的后置通知）
    @AfterThrowing("execution(* com.itheima.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }
}
```

  

![[/Untitled 5 3.png|Untitled 5 3.png]]

  

## 切入点表达式

每一个注解里面都指定了切入点表达式，而且这些切入点表达式都一模一样。此时我们的代码当中就存在了大量的重复性的切入点表达式，假如此时切入点表达式需要变动，就需要将所有的切入点表达式一个一个的来改动，就变得非常繁琐了。

怎么来解决这个切入点表达式重复的问题？ 答案就是：抽取

Spring提供了@PointCut注解，该注解的作用是将公共的切入点表达式抽取出来，需要用到时引用该切入点表达式即可。

```Java
@Slf4j
@Component
@Aspect
public class MyAspect1 {

    //切入点方法（公共的切入点表达式）
    @Pointcut("execution(* com.itheima.service.*.*(..))")
    private void pt(){

    }

    //前置通知（引用切入点）
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before ...");

    }

    //环绕通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();
        //原始方法在执行时：发生异常
        //后续代码不在执行

        log.info("around after ...");
        return result;
    }

    //后置通知
    @After("pt()")
    public void after(JoinPoint joinPoint){
        log.info("after ...");
    }

    //返回后通知（程序在正常执行的情况下，会执行的后置通知）
    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning ...");
    }

    //异常通知（程序在出现异常的情况下，执行的后置通知）
    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }
}
```

## 通知顺序

当在项目开发当中，我们定义了多个切面类，而多个切面类中多个切入点都匹配到了同一个目标方法。此时当目标方法在运行的时候，这多个切面类当中的这些通知方法都会运行。

此时我们就有一个疑问，这多个通知方法到底哪个先运行，哪个后运行？ 下面我们通过程序来验证（这里呢，我们就定义两种类型的通知进行测试，一种是前置通知@Before，一种是后置通知@After）

切面类2:

```Java
@Slf4j
@Component
@Aspect
public class MyAspect2 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect2 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect2 -> after ...");
    }
}
```

切面类3:

```Java
@Slf4j
@Component
@Aspect
public class MyAspect3 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect3 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect3 ->  after ...");
    }
}
```

切面类4:

```Java
@Slf4j
@Component
@Aspect
public class MyAspect4 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
```

  

**查看idea中控制台日志输出**

![[/Untitled 6 3.png|Untitled 6 3.png]]

  

结论:

- 目标方法前的通知方法：字母排名靠前的先执行
- 目标方法后的通知方法：字母排名靠前的后执行

### 控制通知的执行顺序

1. 修改切面类的类名（这种方式非常繁琐、而且不便管理）
2. 使用Spring提供的@Order注解

  

使用@Order注解，控制通知的执行顺序：

  

```Java
@Slf4j
@Component
@Aspect
@Order(2)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect2 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect2 -> before ...");
    }

    //后置通知 
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect2 -> after ...");
    }
}
```

  

```Java
@Slf4j
@Component
@Aspect
@Order(3)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect3 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect3 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect3 ->  after ...");
    }
}
```

  

```Java
@Slf4j
@Component
@Aspect
@Order(1) //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect4 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
```

  

![[/Untitled 7 3.png|Untitled 7 3.png]]

  

通知的执行顺序大家主要知道两点即可：

1. 不同的切面类当中，默认情况下通知的执行顺序是与切面类的类名字母排序是有关系的
2. 可以在切面类上面加上@Order注解，来控制不同的切面类通知的执行顺序

  

# **AOP通知获取参数数据**

![[/Untitled 8 3.png|Untitled 8 3.png]]

  

# **AOP通知获取返回值数据**

![[/Untitled 9 3.png|Untitled 9 3.png]]

  

# Spring AOP中的代理

1. 什么是代理？
    1. 代理是一个对象，它代表另一个对象并控制对它的访问。
2. Spring AOP中的代理
    1. 当您在Spring中定义了一个切面和通知时，Spring AOP会为目标对象创建一个代理对象。当客户端尝试访问目标对象的方法时，实际上是通过代理对象访问的。代理对象知道何时执行通知（例如，在目标方法执行之前或之后）。
3. 代理问题的来源

- 接口 vs. 类的代理：Spring AOP默认使用基于接口的代理。如果目标对象实现了至少一个接口，则Spring将使用Java的Proxy类创建代理。如果目标对象没有实现任何接口，Spring将使用CGLIB库创建一个基于类的代理。有时，这可能导致行为不一致或不预期的行为，特别是当目标类有一些不在接口中定义的方法时。
- 代理的不可知性：由于代理是透明的，开发者可能不知道他们正在与一个代理对象而不是实际的目标对象交互。这可能会导致某些意外的行为或问题，尤其是在调试时。
- 自调用问题：如果一个对象内部的一个方法调用另一个方法（称为自调用），那么这种调用不会通过代理，因此不会触发任何与那个方法关联的通知。这是因为代理只能拦截外部对对象的方法调用。