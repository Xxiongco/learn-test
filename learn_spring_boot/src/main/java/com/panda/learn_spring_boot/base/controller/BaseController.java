package com.panda.learn_spring_boot.base.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/base")
@Validated
public class BaseController {

    @GetMapping
    public String base(){
        return "hello base";
    }
}
