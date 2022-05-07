package com.panda.learn_spring_boot.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestListenerController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public String test(){

        applicationContext.publishEvent(new OneEvent(this,"nihao"));

        return "ok";
    }
}
