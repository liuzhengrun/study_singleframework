package com.study.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Log4j2
public class MvcMethodLogAdvice {

    @Resource
    private HttpServletRequest request;

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "||@annotation(org.springframework.web.bind.annotation.RequestMapping)" +
            "||@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeAdvice(JoinPoint joinPoint) {
        printMethodParams(joinPoint);
    }

    /**
     * @param point
     * @description 打印方法的参数名和参数值
     */
    public void printMethodParams(JoinPoint point) {
        if (point == null) {
            return;
        }
        // Signature 包含了方法名、申明类型以及地址等信息
        // String className = point.getTarget().getClass().getName();
        // String methodName = point.getSignature().getName();
        // 获取方法的参数值数组。
        Object[] method_args = point.getArgs();
        // 获取方法参数名称
        String[] paramNames = ((MethodSignature) point.getSignature()).getParameterNames();
        logParam(paramNames, method_args);
    }

    /**
     * @param paramsArgsName  方法参数名数组
     * @param paramsArgsValue 方法参数值数组
     * @description 打印方法的参数名和参数值, 基本类型直接打印, 非基本类型需要重写toString方法
     */
    private void logParam(String[] paramsArgsName, Object[] paramsArgsValue) {
        if ((paramsArgsName == null || paramsArgsName.length <= 0) ||
                (paramsArgsValue == null || paramsArgsValue.length <= 0)) {
            log.info("url=[" + request.getRequestURL() + "]无请求参数");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("{ ");
        for (int i = 0; i < paramsArgsName.length; i++) {
            String name = paramsArgsName[i];
            if (name.equals("session")) {
                continue;
            }
            Object value = paramsArgsValue[i];
            buffer.append(name + " : ");
            if (null == value) {
                buffer.append(null + " ,");
            } else if (isPrimite(value.getClass())) {
                buffer.append(value + " ,");
            } else {
                buffer.append(value.toString() + " ,");
            }
        }
        String logString = buffer.toString();
        if (logString.contains(",")) {
            logString = logString.substring(0, logString.lastIndexOf(","));
        }
        // buffer.deleteCharAt(buffer.lastIndexOf(","));
        // buffer.append("}");
        logString += "}";
        log.info("url=[" + request.getRequestURL() + "]请求参数为: \033[35;0m" + logString + "\033[0m");
    }

    /**
     * @param clazz
     * @return
     * @description 判断是否为基本类型：包括String
     */
    private boolean isPrimite(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz == String.class) {
            return true;
        } else {
            return false;
        }
    }
}