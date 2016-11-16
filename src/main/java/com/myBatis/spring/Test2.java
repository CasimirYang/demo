package com.myBatis.spring;

import com.activeMQ.spring.MessageSender;
import com.myBatis.UserModel;
import com.spring.collection.MyCollection;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjh on 16/9/25.
 */
@ContextConfiguration(locations= {"/myBatis/spring/*.xml","/redis/redisCache.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test2 {

    @Autowired(required = false)
    @Qualifier("myService")
    private ServiceImpl serviceImpl;

    @Test
    public void testMyCollection(){

        //Object userModel  = serviceImpl.getUser(2);
        System.out.println(serviceImpl.selectClass2());

    }
}