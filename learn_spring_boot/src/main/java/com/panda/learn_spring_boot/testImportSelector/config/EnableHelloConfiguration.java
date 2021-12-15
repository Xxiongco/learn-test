package com.panda.learn_spring_boot.testImportSelector.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public @interface EnableHelloConfiguration {
    String name() default "demo";
    Class<?>[] className();
}
