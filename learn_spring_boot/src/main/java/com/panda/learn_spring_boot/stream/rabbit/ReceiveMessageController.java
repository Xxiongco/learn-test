package com.panda.learn_spring_boot.stream.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    //@Bean
    Consumer<String> send() {
        return str -> {
            System.out.println("我是消费者"+serverPort+"，我收到了消息："+str);
        };
    }

}