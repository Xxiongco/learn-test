package com.panda.learn_spring_boot_redis.delay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * 用于学习redis使用延迟队列
 */
@RestController
@RequestMapping("/delay")
public class DelayController {
    private static final String TEST_DELAY_QUEUE = "test";
    private static final String DEMO_DELAY_QUEUE = "demo";

    private Random random = new Random();

    @Autowired
    private RedisDelayService redisDelayService;

    @GetMapping("/publish")
    public String publish(String msg, Long delayTime) {
        if (delayTime == null) {
            delayTime = 10000L;
        }
        if(msg == null){
            msg = "hello";
        }

        String queue = random.nextBoolean() ? TEST_DELAY_QUEUE : DEMO_DELAY_QUEUE;

        msg = queue + "#" + msg + "#" + (System.currentTimeMillis() + delayTime);
        redisDelayService.publish(queue, msg, delayTime);
        System.out.println("延时: " + delayTime + "ms后消费: " + msg + " now:" + LocalDateTime.now());
        return "success!";
    }

    @Consumer(topic = TEST_DELAY_QUEUE)
    public void consumer(RedisDelayService.DelayMsg delayMsg) {
        System.out.println("TEST消费延时消息: " + delayMsg + " at:" + System.currentTimeMillis());
    }

    @Consumer(topic = DEMO_DELAY_QUEUE)
    public void consumerDemo(RedisDelayService.DelayMsg delayMsg) {
        System.out.println("DEMO消费延时消息: " + delayMsg + " at:" + System.currentTimeMillis());
    }
}
