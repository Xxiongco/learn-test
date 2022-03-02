package com.panda.learn_spring_boot.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/base")
@Validated
public class BaseController {

    @GetMapping
    public String base(){
        return "hello base";
    }
}
