package com.activeMQ.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.MessageListener;
import java.util.Map;

/**
 * Created by yjh on 16/9/22.
 */
 @Service
public class ReceiveMessageByAnnotation {

    @JmsListener(destination="SendToRecv")
    @SendTo("RecvToSend")
    public String processMessage(Map text) {
        System.out.println("Received: " + text);
        return "ACK from handleMessage";
    }

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("/springJMS/receiveByAnnotation.xml"); //用这个就和当前配置的annotation无关了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close application context
        ((ClassPathXmlApplicationContext)ct).close();
    }
}
