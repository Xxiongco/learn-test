package com.panda.learn_spring_boot.base.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("helloController")
public class HelloController extends BaseController{

    @GetMapping("/hello")
    public String hello(){

        return "hello hello";
    }

    @GetMapping("/{name}")
    public String base(@PathVariable("name") String name){
        return "hello base" + name;
    }

}
