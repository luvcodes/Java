package com.itheima.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Component
@Aspect
public class DataAdvice {
    @Pointcut("execution(boolean com.itheima.service.*Service.*(*, *))")
    private void servicePt() {}

    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] pjpArgs = pjp.getArgs();
        for (int i = 0; i < pjpArgs.length; i++) {
            // 判断参数是不是字符串
            if (pjpArgs[i].getClass().equals(String.class)) {
                pjpArgs[i] = pjpArgs[i].toString().trim();
            }
        }

        Object ret = pjp.proceed(pjpArgs);
        return ret;
    }
}
