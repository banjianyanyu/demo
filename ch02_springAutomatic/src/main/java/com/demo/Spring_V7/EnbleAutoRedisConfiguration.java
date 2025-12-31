package com.demo.Spring_V7;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.ElementType;

/**
 * @author Aurora
 * @date 2025年12月31日 21:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(RedisAutoConfiguration.class)
public @interface EnbleAutoRedisConfiguration {
}
