package com.panda;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Demo {
    
    public static void main(String[] args) {
        //连接池配置对象,包含了很多默认配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //初始化Jedis连接池，通常来讲JedisPool是单例的
        JedisPool jedisPool = new JedisPool(poolConfig, "119.23.226.29", 6379);
        Jedis jedis = null;
        try {
            //1.从连接池获取jedis对象
            jedis = jedisPool.getResource();
            //2.执行操作
            jedis.set("hello", "jedis");
            System.out.println(jedis.get("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //如果使用JedisPool，那么close操作不是关闭连接，代表归还连接池
            if(jedis != null){
                jedis.close();
            }
        }   
    }
}