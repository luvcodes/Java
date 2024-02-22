package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * @author ryanw
 */
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.itheima.dao.BookDao.findName(..))")
    private void pt() {}

    @Before("pt()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("before advice...");
    }

//    @After("pt()")
    public void after(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("after advice...");
    }

//    @Around("pt()")
    public Object around(ProceedingJoinPoint psj) {
        Object[] args = psj.getArgs();
        System.out.println(Arrays.toString(args));
        Object ret = null;
        try {
            ret = psj.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return ret;
    }

//    @AfterReturning(value = "pt()", returning = "ret")
    public void afterReturning(JoinPoint jp, String ret) {
        System.out.println("After returning..." + ret);
    }

//    @AfterThrowing(value = "pt()", throwing = "t")
    public void afterThrowing(Throwable t) {
        System.out.println("After throwing..." + t);
    }
}
