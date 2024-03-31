package com.itheima.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ryanw
 */
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 目标资源方法执行前执行，放回true: 放行，返回false: 不放行
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法");
        return true;
    }

    /**
     * 目标资源方法执行后执行
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法");
    }

    /**
     * 视图渲染完毕后执行，最后执行
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法");
    }
}   
