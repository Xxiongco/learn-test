package com.panda.learn_sheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.panda.learn_sheduler.scheduler")
@EnableScheduling
public class LearnShedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnShedulerApplication.class, args);
    }

}
