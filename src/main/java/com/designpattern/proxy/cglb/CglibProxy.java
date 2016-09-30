package com.designpattern.proxy.cglb;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 是通过创建源类的子类进行代理,所以源类不能是final的
 */
public class CglibProxy implements MethodInterceptor {

    /**
     * 创建代理对象
     */
    public Object getInstance(String filename) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealImage.class);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create(new Class[]{String.class},new String[]{filename});
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        Object result;
        result = proxy.invokeSuper(obj, args);
        return result;
    }

}
