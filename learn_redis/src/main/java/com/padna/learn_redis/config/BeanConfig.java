package com.padna.learn_redis.config;

import com.padna.learn_redis.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 学习@ImportResrce注解
 */
@Configuration
public class BeanConfig {

    @Bean
    public User createUser(){
        return new User("xiong","20");
    }
}
