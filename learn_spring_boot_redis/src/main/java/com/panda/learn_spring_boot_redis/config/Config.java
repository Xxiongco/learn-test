package com.panda.learn_spring_boot_redis.config;

import com.panda.learn_spring_boot_redis.redis_message_listener.RedisMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class Config {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory,
                                                   RedisMessageListener listener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //订阅频道test1 和 test2  这个container 可以添加多个 messageListener
        container.addMessageListener(listener, new ChannelTopic("test1"));
        container.addMessageListener(listener, new ChannelTopic("test2"));
        return container;
    }

}
