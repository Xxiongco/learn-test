package com.panda.learn_spring_boot.testImportSelector.controller;

import com.panda.learn_spring_boot.testImportSelector.config.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Hello
public class Controller {

    @GetMapping("/{str}")
    public String get(@PathVariable("str") String str){
        System.out.println("str : " + str);
        return "str : " + str;
    }

    @GetMapping("/{id}")
    public String get2(@PathVariable("id") Long id){
        System.out.println("id : " + id);
        return "id : " + id;
    }
}
