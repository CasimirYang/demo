package com.activeMQ.spring;

import javax.jms.*;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;


/**
 *  receive message using direct message listener
 *
 *  MessageListener              :javax.jms
 *  SessionAwareMessageListener  :spring-jms, contain session
 *
 */
@Service
public class ReceiveMessageByListener implements SessionAwareMessageListener<TextMessage> {

    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
        // This is the received message
        System.out.println("Receive: "+message.getText());

        // Message send back to the replyTo address of the income message.
        // Like replying an email somehow.
        // Let's prepare a reply message - a "ACK" String
        ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
        textMessage.setText("ACK");
        MessageProducer producer = session.createProducer(message.getJMSDestination()); //message.getJMSReplyTo()
        producer.send(textMessage);
    }

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("/springJMS/receiveByListener.xml"); //用这个就和当前配置的annotation无关了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close application context
        ((ClassPathXmlApplicationContext)ct).close();
    }

}