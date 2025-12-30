package com.demo.Spring_V5;

import com.demo.Spring_V4.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Aurora
 * @date 2025年12月30日 22:53
 */
@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class JavaConfig {
}
