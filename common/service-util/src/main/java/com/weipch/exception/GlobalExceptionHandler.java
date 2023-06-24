package com.weipch.exception;

import com.weipch.result.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//AOP 面向切面
@ControllerAdvice
public class GlobalExceptionHandler {

    //异常处理器
    @ExceptionHandler(Exception.class)
    @ResponseBody  //返回json数据
    public ResponseResult error(Exception e) {
        e.printStackTrace();
        return ResponseResult.error(null);
    }

    //自定义异常处理
    @ExceptionHandler(SsyxException.class)
    @ResponseBody
    public ResponseResult error(SsyxException exception) {
        return ResponseResult.build(null,exception.getCode(),exception.getMessage());
    }
}
