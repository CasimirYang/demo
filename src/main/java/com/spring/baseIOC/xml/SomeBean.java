package com.spring.baseIOC.xml;

/**
 * Created by casimiryang on 2016/3/29.
 */
public class SomeBean {
    private String someBean;
    private SomeBean someBeanObj;

    public SomeBean(){} //需要提供默认构造函数 即使是private 也可以

    public SomeBean(String args){
        this.someBean = args;
    }

    public SomeBean(String args,int args2){
        this.someBean = args;
    }

    public SomeBean(String someBean, SomeBean someBeanObj) {
        this.someBean = someBean;
        this.someBeanObj = someBeanObj;
    }

    public void setSomeBean(String someBean) {
        this.someBean = someBean;
    }

    public String getSomeBean() {
        return someBean;
    }

    public SomeBean getSomeBeanObj() {
        return someBeanObj;
    }

    public void setSomeBeanObj(SomeBean someBeanObj) {
        this.someBeanObj = someBeanObj;
    }

    class innerClass{
    }
}