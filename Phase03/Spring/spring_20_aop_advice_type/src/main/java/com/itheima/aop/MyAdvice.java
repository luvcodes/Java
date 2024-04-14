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
    @Pointcut("execution(int com.itheima.dao.BookDao.select())")
    private void pt2() {}

//    @Before("pt()")
    public void before() {
        System.out.println("before advice...");
    }

//    @After("pt()")
    public void after() {
        System.out.println("after advice...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice...");
        // 表示对原始操作的调用
        // 抛出异常是因为它不知道原始方法里有没有异常
        Object ret = pjp.proceed();
        System.out.println("around after advice...");
        return ret;
    }

    @Around("pt2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice...");
        Integer ret = (Integer) pjp.proceed();
        System.out.println("around after advice...");
        return ret;
    }

    /**
     * 下面两个用的比较少
     * */
    @AfterReturning("pt2()")
    public void afterRuturning() {
        System.out.println("afterReturning advice ...");
    }

    @AfterThrowing("pt2()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice...");
    }
}
