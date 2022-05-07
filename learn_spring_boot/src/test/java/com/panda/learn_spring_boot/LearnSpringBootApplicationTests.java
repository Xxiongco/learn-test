package com.panda.learn_spring_boot;

import com.panda.learn_spring_boot.listener.OneEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class LearnSpringBootApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void test(){
        applicationContext.publishEvent(new OneEvent(this,"nihao"));
    }

}
