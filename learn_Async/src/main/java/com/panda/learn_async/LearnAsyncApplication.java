package com.panda.learn_async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.panda.learn_async.springAsync")
@EnableAsync

public class LearnAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAsyncApplication.class, args);
    }

}
