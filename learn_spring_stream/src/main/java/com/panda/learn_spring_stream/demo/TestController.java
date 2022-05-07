package com.panda.learn_spring_stream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class TestController {

    @Autowired
    private MqMessageProducer mqMessageProducer;
    @GetMapping(value = "/testMq/{msg}")
    public String testMq(String msg){
        mqMessageProducer.sendMsg(msg);
        return "发送成功";
    }
}
