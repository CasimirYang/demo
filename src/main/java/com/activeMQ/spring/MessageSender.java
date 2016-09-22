package com.activeMQ.spring;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.jms.*;

/**
 * Created by yjh on 16/9/22.
 */
@Service
public class MessageSender {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send() {

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("key1","value1");
                mapMessage.setBoolean("flag",true);
                mapMessage.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
                return mapMessage;
            }
        });
    }

    public void send(final Destination dest, final String text) {
        this.jmsTemplate.send(dest,new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    public static void main(String[] args) {
        // init spring context
        //WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc);
        //WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/springJMS/sentMessage.xml");

        MessageSender jmsMessageSender = (MessageSender)ctx.getBean("messageSender");
        // send to default destination
        jmsMessageSender.send();

        // send to a code specified destination
        Queue queue = new ActiveMQQueue("AnotherDest");
        jmsMessageSender.send(queue, "hello Another Message");


        ((ClassPathXmlApplicationContext)ctx).close();
    }

}
