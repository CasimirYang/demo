package com.demo;

import redis.clients.jedis.Jedis;

/**
 * Created by casimiryang on 2016/3/11.
 */
public class MyJedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        //jedis.set("foo", "bar");
        System.out.print(jedis.exists("foo"));
        jedis.expire("foo",5);
        jedis.del("");
        String value = jedis.get("foo");
        System.out.print(value);
    }

}
