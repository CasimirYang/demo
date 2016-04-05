package com.spring.baseIOC.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by casimiryang on 2016/3/29.
 */

@Configuration
@ComponentScan("com.spring.baseIOC")   //扫描当前类下的组件 如bean
public class ConfigWithAnnotationTest {

    @Bean   //修饰方法
    @Qualifier("someBean") //如果全局只有一个String 需要被注入，那这里可以省略Qualifier
    String method(){
        return new String("cvszz");
    }

    @Scope("prototype")
    @Bean(name = "another_bean")
    @Qualifier("someBean2")
    String method2(){
        return new String("cvszz22");
    }

    @Autowired          //声明这个field 会被自动注入
    @Qualifier("SomeBeanAnnotation")
    private SomeBeanAnnotation someBean;

    @Autowired
    @Qualifier("SomeBeanAnnotation")
    private SomeBeanAnnotation someBean2;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigWithAnnotationTest.class,SomeBeanAnnotation.class);
        ConfigWithAnnotationTest thisClass = context.getBean(ConfigWithAnnotationTest.class);
        System.out.println(thisClass.someBean.getSomeBean());
        System.out.println(context.getBean("another_bean"));
        SomeBeanAnnotation someBeanAnnotation = context.getBean(SomeBeanAnnotation.class);
        System.out.println(someBeanAnnotation.getSomeBean());

        ApplicationContext ct = new ClassPathXmlApplicationContext("/baseConfig.xml"); //用这个就和当前配置的annotation无关了
        System.out.println(ct.getBean("innerClassId"));
    }

}
