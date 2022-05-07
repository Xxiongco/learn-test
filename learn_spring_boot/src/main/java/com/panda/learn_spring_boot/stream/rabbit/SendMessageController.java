package com.panda.learn_spring_boot.stream.rabbit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @RequestMapping("/send")
    public void send(){
        messageProvider.sendMethod();
    }
}

