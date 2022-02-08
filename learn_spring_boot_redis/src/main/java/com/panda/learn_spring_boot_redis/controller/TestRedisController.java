package com.panda.learn_spring_boot_redis.controller;

import com.panda.learn_spring_boot_redis.delay.Consumer;
import com.panda.learn_spring_boot_redis.delay.RedisDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping
public class TestRedisController {
    /**
     * 生效的原因是由于在AutoConfig的配置文件中有生成这两个Bean，springboot 自动配置包的作用
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/get")
    public String get(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
        return "ok";
    }

    @GetMapping("/test")
    public String test(){
       redisTemplate.convertAndSend("test1","hello");
       redisTemplate.convertAndSend("test2","hello");
       return "ok";
    }
}
