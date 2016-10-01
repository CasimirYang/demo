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
import org.springframework.test.annotation.SystemProfileValueSource;
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
public class ServiceImplTest {

    @Autowired
    @Qualifier("myService")
    private ServiceImpl serviceImpl;

    @Test
    public void testMyCollection(){
     //   serviceImpl.testTransactional();
//        long time3 = System.currentTimeMillis();
//        for(int i=1;i<2;i++){
//            long time1 = System.currentTimeMillis();
//            serviceImpl.getCid(i);
//            // serviceImpl.selectClass2();
//            long time2 = System.currentTimeMillis();
//            System.out.println(time2-time1);
//        }
//        long time4 = System.currentTimeMillis();
//        System.out.println(time4-time3);
        //829
        //508
        //serviceImpl.update(2);
//        List<UserModel> list = serviceImpl.getUsers();
//        for (UserModel userModel: list){
//            System.out.println(userModel.getName());
//        }
//        ApplicationContext ct = new ClassPathXmlApplicationContext("/springJMS/receiveByListener.xml"); //用这个就和当前配置的annotation无关了
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // close application context
//        ((ClassPathXmlApplicationContext)ct).close();

    }
}