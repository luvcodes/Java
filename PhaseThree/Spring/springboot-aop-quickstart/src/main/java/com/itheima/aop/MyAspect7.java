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
public class MyAspect7 {

    //匹配DeptServiceImpl中的 list() 和 delete(Integer id)方法
    //@Pointcut("execution(* com.itheima.service.DeptService.list()) || execution(* com.itheima.service.DeptService.delete(java.lang.Integer))")
    @Pointcut("@annotation(com.itheima.aop.MyLog)")
    private void pt(){}

    @Before("pt()")
    public void before(){
        log.info("MyAspect7 ... before ...");
    }

}
