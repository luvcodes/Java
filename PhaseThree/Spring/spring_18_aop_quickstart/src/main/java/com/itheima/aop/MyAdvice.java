package com.itheima.aop;

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

    @Before("pt()")
    public void beforeUpdate() {
        System.out.println(System.currentTimeMillis());
    }

    @After("pt()")
    public void afterUpdate() {
        System.out.println(System.currentTimeMillis());
    }
}
