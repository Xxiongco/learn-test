package org.panda.learn_rabbitmq.service;


public interface RabbitMQService {
    String sendMsg(String msg) throws Exception;
}