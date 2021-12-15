package com.padna.learn_async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@ComponentScan("com.padna.learn_async.springAsync")
@EnableAsync

public class LearnAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAsyncApplication.class, args);
    }

}
