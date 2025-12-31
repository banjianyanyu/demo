package com.demo.Spring_V11;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aurora
 * @date 2025年12月31日 22:45
 */
@Configuration
public class MessageAutoConfiguration {
    @Bean
    @ConditionalOnProperty(name = "message.type", havingValue = "sms")
    public MessageService smsService() {


        return new SmsService();
    }

    @Bean
    @ConditionalOnProperty(name = "message.type", havingValue = "email")
    public MessageService emailService() {


        return new EmailService();
    }
}
