package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author ryanw
 */
@Component
@Aspect
public class MyAdvice {
    // 切入点
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt() {}

/*    @Before("pt()")
    public void beforeUpdate() {
        System.out.println(System.currentTimeMillis());
    }

    @After("pt()")
    public void afterUpdate() {
        System.out.println(System.currentTimeMillis());
    }*/

    @Around("pt()")
    public Object aroundUpdate(ProceedingJoinPoint joinPoint) throws Throwable {
        // 在目标方法执行之前打印当前时间
        System.out.println(System.currentTimeMillis());

        try {
            // 执行目标方法
            Object result = joinPoint.proceed();

            // 在目标方法执行之后再次打印当前时间
            System.out.println(System.currentTimeMillis());

            return result;
        } catch (Throwable throwable) {
            // 可以在这里处理异常
            throw throwable;
        }
    }
}
