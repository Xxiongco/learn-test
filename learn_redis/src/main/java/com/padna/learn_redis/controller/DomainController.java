package com.padna.learn_redis.controller;


import com.padna.learn_redis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private User user;

    @RequestMapping
    public User getUser(){
        return user;
    }
}
