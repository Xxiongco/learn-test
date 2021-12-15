package com.panda.learn_spring_boot;

import com.panda.learn_spring_boot.testImportSelector.config.EnableHelloConfiguration;
import com.panda.learn_spring_boot.testImportSelector.config.Hello;
import com.panda.learn_spring_boot.testImportSelector.domian.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用于测试@ImportSelector中的参数AnnotationMetadata是什么。它的功能是可以获取到@Configuration注解下面的所有注解
 * 应该注意到，有一些注解继承自@Configuration，所以，继承的那个注解同样拥有一样的功能，同时，
 * AnnotationMetadata的getClass可以获取到该注解标注所在的那个类的全路径。
 */
@SpringBootApplication
@Hello
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

}
