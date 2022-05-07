package com.panda.learn_spring_boot.base.controller;


import com.panda.learn_spring_boot.base.domain.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestObjectNotNullController {

    @PostMapping
    public Student testStudent(@RequestBody Student student){

        System.out.println(student);

        return student;

    }
}
