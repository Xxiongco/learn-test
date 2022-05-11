package com.panda.learn_spring_stream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.StreamRetryTemplate;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.Map;

@EnableBinding(Sink.class)
@IntegrationComponentScan
@MessageEndpoint
@SpringBootApplication
public class ReceiverApplication {
    @StreamListener(Sink.INPUT)
    public void accept(String msg){
        System.out.println("接收到" + " : " + msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }
}