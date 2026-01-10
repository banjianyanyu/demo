package com.bjyy.ch11_springaop.Aspect;

import com.bjyy.ch11_springaop.annotation.LogExecution;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class LogExecutionAspect {

    /**
     * 切点：只拦截带 @LogExecution 的方法
     */
    @Pointcut("@annotation(com.bjyy.ch11_springaop.annotation.LogExecution)")
    public void logPointcut() {}

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogExecution logExecution = method.getAnnotation(LogExecution.class);
        String desc = logExecution.value();

        long start = System.currentTimeMillis();
        log.info("【AOP】开始执行：{}，描述：{}",
                method.getName(), desc);

        try {
            Object result = joinPoint.proceed();
            log.info("【AOP】执行成功：{}，返回值：{}",
                    method.getName(), result);
            return result;
        } catch (Exception e) {
            log.error("【AOP】执行异常：{}", method.getName(), e);
            throw e;
        } finally {
            log.info("【AOP】执行耗时：{} ms",
                    System.currentTimeMillis() - start);
        }
    }
}
