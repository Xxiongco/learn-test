package com.panda.learn_activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class LearnActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnActivitiApplication.class, args);
    }

}
