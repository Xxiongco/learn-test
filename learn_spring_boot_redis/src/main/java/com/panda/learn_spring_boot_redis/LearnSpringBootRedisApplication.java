package com.panda.learn_spring_boot_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearnSpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootRedisApplication.class, args);
    }
}
