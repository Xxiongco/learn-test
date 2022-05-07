package com.example.learn_spring_boot_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class LearnSpringBoot2Application {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBoot2Application.class, args);
    }

    @Bean
    public Supplier<String> pkslowSource() {
        return () -> {
            String message = "www.pkslow.com";
            System.out.println("Sending value: " + message);
            return message;
        };
    }

    @Bean
    public Consumer<String> pkslowSink() {
        return message -> {
            System.out.println("Received message " + message);
        };
    }

}
