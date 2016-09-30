package com.myBatis.spring;

import com.activeMQ.spring.MessageSender;
import com.myBatis.ClassMapper;
import com.myBatis.ClassModel;
import com.myBatis.UserMapper;
import com.myBatis.UserModel;
import com.sun.tools.internal.jxc.SchemaGenerator;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.jms.Queue;
import java.util.List;

/**
 * Created by yjh on 16/9/25.
 */

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED)
public class ServiceImpl {

    private UserMapper userMapper;
    private ClassMapper classMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setClassMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    public void update(int id){
        this.userMapper.updateUser(1);

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

    public Object getUser(int id){return this.userMapper.selectUser(id);}
    public List getUsers(){
       return this.userMapper.selectUsers();
    }

    @Transactional
    public void updateAge(boolean sleep){
        int age = this.userMapper.selectAge(1);
        System.out.println("age1: "+age +" thread name:"+Thread.currentThread().getName());
       // this.userMapper.updateAge(age+1,1);
        int age2 = this.userMapper.selectAge(1);
        System.out.println("age2: "+age2+" thread name:"+Thread.currentThread().getName());
        try {
            if(sleep){
                Thread.sleep(20000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<ClassModel> selectClass(){
        return this.classMapper.selectClass();
    }

    public List<ClassModel> selectClass2(){
        return this.classMapper.selectClass2();
    }
}
