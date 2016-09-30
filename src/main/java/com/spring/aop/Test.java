package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/aop.xml");
        PersonServiceBean bean = (PersonServiceBean) ctx.getBean("myServiceBean");
        bean.update("param1",2);
    }
}
