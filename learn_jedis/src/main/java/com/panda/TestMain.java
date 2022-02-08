package com.panda;

import redis.clients.jedis.Jedis;

public class TestMain {
    public static void main(String[] args) {
        //1.生成一个jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("localhost", 6379);
        //带密码需要执行认证方法
        //jedis.auth("123456");
        //2.jedis执行set操作
        jedis.set("hello", "world");
        //3.jedis执行get操作，value="world"
        String value = jedis.get("hello");
    }
}
