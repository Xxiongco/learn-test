package org.panda.learn_rabbitmq.listener;

import org.panda.learn_rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = RabbitMQConfig.RABBITMQ_DEMO_TOPIC)
public class rabbitMqConsumer {

    @RabbitHandler
    public void process(Map map){
        System.out.println("消费者消费消息：" + map.toString());
    }

}
