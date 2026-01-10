package com.bjyy.ch11_springaop.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 切点：service 包下所有方法
     */
    @Pointcut("execution(* com.bjyy.ch11_springaop.service..*(..))")
    public void servicePointcut() {
    }

    /**
     * 环绕通知
     */
    @Around("servicePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        log.info("【AOP】方法开始：{}", methodName);

        try {
            Object result = joinPoint.proceed(); // 执行目标方法
            log.info("【AOP】方法结束：{}，返回值：{}", methodName, result);
            return result;
        } catch (Throwable ex) {
            log.error("【AOP】方法异常：{}", methodName, ex);
            throw ex;
        } finally {
            log.info("【AOP】方法耗时：{} ms",
                    System.currentTimeMillis() - start);
        }
    }
}
