package com.panda.learn_spring_boot.testImportSelector.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        // com.panda.learn_spring_boot.LearnSpringBootApplication
        System.out.println('\n');
        System.out.println("---------------------- in MyImportBeanDefinitionRegistrar ------------------");
        System.out.println(importingClassMetadata.getClassName());
        System.out.println("---------------------- in MyImportBeanDefinitionRegistrar ------------------");
        System.out.println('\n');

    }
}
