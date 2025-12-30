package com.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Aurora
 * @date 2025年12月30日 21:22
 */
public class Processor implements BeanPostProcessor {

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if ("dog".equals(beanName)){
            System.out.println("4.初始化postProcessBefore 方法");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("dog".equals(beanName)){
            System.out.println("7.初始化postProcessAfter 方法");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
