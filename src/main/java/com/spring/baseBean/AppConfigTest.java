package com.spring.baseBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {


    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientServiceImpl client1 = (ClientServiceImpl)context.getBean("b1");
        ClientServiceImpl client2 = (ClientServiceImpl)context.getBean("b2");
        client1.fun();
        client2.fun();
    }
}
