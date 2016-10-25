package com.redis;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yjh on 16/10/17.
 */
public class RedisServiceTest2 extends RedisServiceTest {


    @Override
    protected Integer fun() throws IOException {
       return 1;
    }
}
