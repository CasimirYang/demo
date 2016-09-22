package com.activeMQ.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 http://shengwangi.blogspot.com/2014/10/spring-jms-with-activemq-helloworld-example-recv-via-adapter.html
 */

@Service
public class ReceiveMessageByAdapter {

    //handleMessage is default name
    //return value is response message
    public String handleMessage(String text) {
        System.out.println("Received: " + text);
        return null;
    }

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("/springJMS/receiveByListenerAdapter.xml");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close application context
        ((ClassPathXmlApplicationContext)ct).close();
    }
}
