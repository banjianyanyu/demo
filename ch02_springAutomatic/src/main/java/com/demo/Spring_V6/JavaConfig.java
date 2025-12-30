package com.demo.Spring_V6;

import com.demo.Spring_V5.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Aurora
 * @date 2025年12月30日 22:53
 */
@Configuration
public class JavaConfig {
     @Conditional(value =  ConditionOnClass.class)
     @Bean
    public DeptService  deptService(){
        return new DeptService();
    }
}
