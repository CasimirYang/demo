package com.spring.lookup_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("/spring/method_DI.xml");
        UserManager  userManager = (UserManager) ct.getBean("single_A");
        UserManager  userManager2 = (UserManager) ct.getBean("single_A");
        User  user = (User) ct.getBean("non_single_B");
        //以下三个user 都不是同一个对象
        userManager.run();
        userManager2.run();
        System.out.println(user);
    }
}

