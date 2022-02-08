package com.panda.learn_spring_boot;

import com.panda.learn_spring_boot.testImportSelector.config.Hello;;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 用于测试@ImportSelector中的参数AnnotationMetadata是什么。
 * 通过这个参数我们可以获取到@Import标注的Class的各种信息。
 * AnnotationMetadata的getClass可以获取到该注解标注所在的那个类的全路径。
 */
@SpringBootApplication
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

}
