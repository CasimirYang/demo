package com.designpattern.proxy.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;
    /**
     * 返回一个代理类
     * @return
     */
    public Object getInstance(String filename) {
        this.target = new RealImage(filename); //代理类控制目标类的创建
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        result= method.invoke(target, args);
        return result;
    }
}
