package com.demo.Spring_V6;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Aurora
 * @date 2025年12月30日 23:09
 */
public class ConditionOnClass implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            if (context.getClassLoader().loadClass("com.demo.Spring_V6.Test666") != null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
