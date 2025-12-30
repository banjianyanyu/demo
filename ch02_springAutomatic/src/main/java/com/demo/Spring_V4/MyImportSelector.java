package com.demo.Spring_V4;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Aurora
 * @date 2025年12月30日 22:53
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Logger.class.getName(),Cache.class.getName()};
    }
}
