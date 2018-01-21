package com.gerry.nettywebsocket;

import redis.clients.jedis.Jedis;

public class SendApplication {
    public static void main(String[] args) throws Exception {

        Jedis jedis = new Jedis("windows.vigekoo.com",6379);
        jedis.auth("5DX@hzgs");

        jedis.publish("redisChat", "测试文字1");
        Thread.sleep(5000);
        jedis.publish("redisChat", "测试文字222");
        Thread.sleep(5000);
        jedis.publish("redisChat", "测试文字333333");
    }
}
