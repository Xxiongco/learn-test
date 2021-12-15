package com.panda.learn_spring_boot.testImportSelector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {

    @GetMapping
    public String get(){
        String test = "hello in selector";
        System.out.println(test);
        return test;
    }
}
