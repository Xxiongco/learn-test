package com.panda.learn_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * controller 的继承时，子类要有与父类不一样的映射，（子类和父类都以Bean）
 *
 * 当只有子类的Bean存在时，（父类没有@Controller，这样就不存在），此时子类没有在类上声明
 * @RequestMapping 而父类有，那么此时依然可以从父类的路径加上子类的路径访问相关的路径。
 *
 *
 *
 */

@SpringBootApplication
//@ComponentScan(basePackages = "com.panda.learn_spring_boot.listener")
//@ComponentScan(basePackages = "com.panda.learn_spring_boot.aop")
@ComponentScan(basePackages = "com.panda.learn_spring_boot.stream")
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

}
