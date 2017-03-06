package com.redis;

import com.myBatis.spring.ServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yjh on 16/10/1.
 */

public class RedisServiceTest{

    protected Object fun() throws IOException {
       return new Object();
    }
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("/myBatis/spring/*.xml","/redis/redisCache.xml");
            RedisService serviceImpl = (RedisService) context.getBean("redisBean");
            serviceImpl.testTran(true);
        }
}
