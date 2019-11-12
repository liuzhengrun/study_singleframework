package com.study.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 异步操作，异常处理
 * lzr
 * MyAsyncUncaughtExceptionHandler
 */
@Log4j2
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("ex=",ex,"，方法名称",method.getName(),"，参数",params.toString());
    }
}