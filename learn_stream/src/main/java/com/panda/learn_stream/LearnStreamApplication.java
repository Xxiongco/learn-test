package com.panda.learn_stream;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.core.log.LogMessage;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding
public class LearnStreamApplication {

//    private static final Logger log = LoggerFactory.getLogger(LearnStreamApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LearnStreamApplication.class, args);
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public LogMessage enrichLogMessage(LogMessage log) {
        return null;
    }

}
