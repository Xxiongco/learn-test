package com.panda.learn_spring_boot_redis.delay;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 用于学习redis使用延迟队列
 */
@Service
public class RedisDelayService  implements ApplicationContextAware {

    private static final Long DELETE_SUCCESS = 1L;

    private Set<String> topic = new HashSet<>();

    private ApplicationContext applicationContext;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     *  从队列中获取数据
     * @param key
     * @return
     */
    public String fetchOne(String key) {
        Set<String> sets = redisTemplate.opsForZSet().rangeByScore(key, 0, System.currentTimeMillis(), 0, 3);
        if (CollectionUtils.isEmpty(sets)) {
            return null;
        }

        for (String val : sets) {
            if (DELETE_SUCCESS.equals(redisTemplate.opsForZSet().remove(key, val))) {
                // 删除成功，表示抢占到
                return val;
            }
        }
        return null;
    }

    /**
     * 写入队列
     * @param key
     * @param val
     * @param delayTime
     */
    public void publish(String key, Object val, long delayTime) {

        topic.add(key);
        String strVal = val instanceof String ? (String) val : JSONObject.toJSONString(val);

        redisTemplate.opsForZSet().add(key, strVal, System.currentTimeMillis() + delayTime);
    }

    @Scheduled(fixedRate = 10_000)
    public void schedule() {
        for (String specialTopic : topic) {
            String cell = fetchOne(specialTopic);
            if (cell != null) {
                applicationContext.publishEvent(new DelayMsg(this, cell, specialTopic));
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ToString
    public static class DelayMsg extends ApplicationEvent {
        @Getter
        private String msg;
        @Getter
        private String topic;

        public DelayMsg(Object source, String msg, String topic) {
            super(source);
            this.msg = msg;
            this.topic = topic;
        }
    }




}
