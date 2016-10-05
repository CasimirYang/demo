package com.spring.containerExtension;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  注解：@Component 修饰自定义的BeanPostProcessor类, 并加到context里面(或者BeanFactory里面)。
 *  xml:  <bean class="com.spring.containerExtension.MyBeanPostProcessor" />
 *
 1. 接口中的两个方法都要将传入的bean返回，而不能返回null
 2. 不要将BeanPostProcessor标记为延迟初始化，因为如果这样做，Spring容器将不会注册它们.
 3. BeanPostProcessors在各自容器内有效。当使用容器继承时，BeanPostProcessors缺不会继承。
 *
 */

@Configuration
public class MyBeanPostProcessorTest {

    @Bean
   MyBean getMyBean(){
       return new MyBean();
   }

    public static void main(String[] args) {
     /*   ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanPostProcessorTest.class,MyBeanPostProcessor.class);
        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean);*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/containerExtension.xml");
        System.out.println( context.getBean("myBean"));
    }
}
