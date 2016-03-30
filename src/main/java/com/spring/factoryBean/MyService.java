package com.spring.factoryBean;

/**
 * Created by casimiryang on 2016/3/30.
 */
public class MyService {
private static MyService myService = new MyService();
    private MyService() {}

    public static MyService createInstanceByStatic() {
        return myService;
    }

    public MyService createInstance() {
        return myService;
    }
}