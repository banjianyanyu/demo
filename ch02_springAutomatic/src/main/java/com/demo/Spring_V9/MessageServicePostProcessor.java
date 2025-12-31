package com.demo.Spring_V9;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Aurora
 * @date 2025年12月31日 21:53
 */
public class MessageServicePostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof MessageService) {

            return new MessageService() {

                @Override
                public String getMessage() {

                    return ((MessageService) bean).getMessage() + " [Processed by Spring SPI]";
                }
            };
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
