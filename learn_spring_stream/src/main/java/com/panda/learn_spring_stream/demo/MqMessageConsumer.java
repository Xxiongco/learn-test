package com.panda.learn_spring_stream.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(MqMessageSource.class)
public class MqMessageConsumer {
    @StreamListener(MqMessageSource.TEST_IN_PUT)
    public void messageInPut(Message<String> message) {
        System.err.println(" 消息接收成功：" + message.getPayload());
    }
}