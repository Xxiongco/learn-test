package com.panda.learn_spring_boot_redis.redis_message_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {
 
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
 
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取消息
        byte[] messageBody = message.getBody();
        // 使用值序列化器转换
        Object msg = stringRedisTemplate.getValueSerializer().deserialize(messageBody);
        // 获取监听的频道
        byte[] channelByte = message.getChannel();
        // 使用字符串序列化器转换
        Object channel = stringRedisTemplate.getStringSerializer().deserialize(channelByte);
        // 渠道名称转换
        String patternStr = new String(pattern);
        System.out.println(patternStr);
        System.out.println("---频道---: " + channel);
        System.out.println("---消息内容---: " + msg);
    }
}