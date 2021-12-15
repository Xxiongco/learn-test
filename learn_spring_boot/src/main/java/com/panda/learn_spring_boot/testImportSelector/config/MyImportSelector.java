package com.panda.learn_spring_boot.testImportSelector.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Map;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(importingClassMetadata.getClassName());
        System.out.println("demo");
        importingClassMetadata.getAnnotationTypes().forEach(item -> System.out.println(item));
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableHelloConfiguration.class.getName(), true));
        Iterator<Map.Entry<String, Object>> iterator = attributes.entrySet().iterator();
        System.out.println(attributes.isEmpty());
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue() );
        }
        System.out.println("*****************************");
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(Hello.class.getName(), true));
        Iterator<Map.Entry<String, Object>> iterator1 = annotationAttributes.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Object> next = iterator1.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
        return new String[0];
    }
}
