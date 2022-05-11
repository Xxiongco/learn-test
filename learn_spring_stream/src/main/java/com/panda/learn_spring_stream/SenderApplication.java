package com.panda.learn_spring_stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@RestController
@SpringBootApplication
public class SenderApplication {
    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    @GetMapping("/send/{msg}")
    public String write (@PathVariable("msg")String msg){
        channel.send(MessageBuilder.withPayload(msg).build());
        System.out.println("发送" + " : " + msg);
        return "发送成功" + msg;
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}