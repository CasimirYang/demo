package com.myBatis.spring;

import com.activeMQ.spring.MessageSender;
import com.myBatis.UserMapper;
import com.myBatis.UserModel;
import com.sun.tools.internal.jxc.SchemaGenerator;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.List;

/**
 * Created by yjh on 16/9/25.
 */

@Transactional
public class ServiceImpl {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserModel doSomeBusinessStuff(int userId) {
        UserModel userModel = this.userMapper.selectUser(userId);
        System.out.print(userModel.toString());
        return  userModel;
    }

    public void update(int id){
        this.userMapper.updateUser(1);
        this.userMapper.updateUser2(2);

//        ApplicationContext ct = new ClassPathXmlApplicationContext("/springJMS/receiveByListener.xml"); //用这个就和当前配置的annotation无关了
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // close application context
//        ((ClassPathXmlApplicationContext)ct).close();
        //throw new RuntimeException("----/====/");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/springJMS/sentMessage.xml");
//
//        MessageSender jmsMessageSender = (MessageSender)ctx.getBean("messageSender");
//        // send to default destination
//        jmsMessageSender.send();
//
//        // send to a code specified destination
//        Queue queue = new ActiveMQQueue("AnotherDest");
//        jmsMessageSender.send(queue, "hello Another Message");
//
//
//        ((ClassPathXmlApplicationContext)ctx).close();
//
    }

    public List getUsers(){
       return this.userMapper.selectUsers();
    }

}
