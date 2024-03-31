package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ryanw
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 捕获所有异常
    @ExceptionHandler(Exception.class)
    public Result exceptionHander(Exception ex) {
        ex.printStackTrace();
        return Result.error("对不起,操作失败,请联系管理员");
    }
}
