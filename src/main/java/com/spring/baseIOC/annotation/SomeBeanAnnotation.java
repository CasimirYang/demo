package com.spring.baseIOC.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * Created by casimiryang on 2016/3/29.
 */
@Configuration  //当前类使用了annotation 方式配置
@Qualifier("SomeBeanAnnotation")
public class SomeBeanAnnotation {

    @Autowired
    @Qualifier("another_bean2")
    private String someBean;


    public SomeBeanAnnotation(){}

    public SomeBeanAnnotation(String args){
        this.someBean = args;
    }


    public void setSomeBean(String someBean) {
        this.someBean = someBean;
    }

    public String getSomeBean() {
        return someBean;
    }
}
