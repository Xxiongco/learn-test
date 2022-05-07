package com.panda.learn_spring_stream.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface  MqMessageSource {
    String TEST_OUT_PUT = "testOutPut";
    @Output(TEST_OUT_PUT)
    MessageChannel testOutPut();

    String TEST_IN_PUT = "testInPut";
    @Input(TEST_IN_PUT)
    SubscribableChannel testInPut();
}