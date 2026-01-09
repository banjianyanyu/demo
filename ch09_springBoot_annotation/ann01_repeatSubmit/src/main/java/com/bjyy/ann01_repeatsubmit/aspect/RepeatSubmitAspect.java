package com.bjyy.ann01_repeatsubmit.aspect;

import com.bjyy.ann01_repeatsubmit.annotation.RepeatSubmit;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RepeatSubmitAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Around("@annotation(repeatSubmit)")
    public Object around(ProceedingJoinPoint joinPoint,
                         RepeatSubmit repeatSubmit) throws Throwable {

        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        String key = buildKey(joinPoint, request);

        // SETNX + 过期时间
        Boolean success = stringRedisTemplate.opsForValue()
                .setIfAbsent(key, "1",
                        repeatSubmit.interval(), TimeUnit.SECONDS);

        if (Boolean.FALSE.equals(success)) {
            throw new RuntimeException(repeatSubmit.message());
        }

        return joinPoint.proceed();
    }

    private String buildKey(ProceedingJoinPoint joinPoint,
                            HttpServletRequest request) {

        String uri = request.getRequestURI();
        String userId = "10001"; // 实际从 token / session 获取
        String params = Arrays.toString(joinPoint.getArgs());

        return "repeat_submit:" + uri + ":" + userId + ":" + params.hashCode();
    }
}
