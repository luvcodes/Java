package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类
@Slf4j
//@Aspect
@Component
public class MyAspect6 {

    //@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Pointcut("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //@Pointcut("execution(void delete(java.lang.Integer))") //包名.类名不建议省略
    //@Pointcut("execution(void com.itheima.service.DeptService.delete(java.lang.Integer))")

    //@Pointcut("execution(void com.itheima.service.DeptService.*(java.lang.Integer))")
    //@Pointcut("execution(* com.*.service.DeptService.*(*))")
    //@Pointcut("execution(* com.itheima.service.*Service.delete*(*))")

    //@Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    //@Pointcut("execution(* com..DeptService.*(..))")
    //@Pointcut("execution(* com..*.*(..))")
    //@Pointcut("execution(* *(..))") //慎用

    @Pointcut("execution(* com.itheima.service.DeptService.list()) || " +
            "execution(* com.itheima.service.DeptService.delete(java.lang.Integer))")
    private void pt(){}

    @Before("pt()")
    public void before(){
        log.info("MyAspect6 ... before ...");
    }

}
