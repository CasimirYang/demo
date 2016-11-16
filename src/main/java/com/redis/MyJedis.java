package com.redis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casimiryang on 2016/3/11.
 */
public class MyJedis {

    public static void main(String[] args) {
        List<String> list =  new ArrayList();
        System.out.print("1");
        for (String item : list){
            System.out.print(item);
        }
        System.out.print("2");
//        Jedis jedis = new Jedis("localhost");
//        //jedis.set("foo", "bar");
//        System.out.print(jedis.exists("foo"));
//        jedis.expire("foo",5);
//        jedis.del("");
//        String value = jedis.get("foo");
//        System.out.print(value);
    }

}
