package com.padna.learn_redis.controller;

import com.padna.learn_redis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping
    public void setRedis(){
        stringRedisTemplate.convertAndSend("cat","猫");
    }

    public void setString(String key , String value){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key,value);
    }

    public void setValues(String key){
        User user = new User();

        ValueOperations valueOperations = redisTemplate.opsForValue();

        valueOperations.set(key,user);
    }

}
