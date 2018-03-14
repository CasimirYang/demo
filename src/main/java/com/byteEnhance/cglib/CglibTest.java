package com.byteEnhance.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CglibTest {

    private String sayHello(String name) {
        return "Hello " + name;
    }

    /**
     * 拦截返回值
     */
    public void returnTheSameValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!"); //拦截特定方法可以通过MethodInterceptor去判断
        CglibTest proxy = (CglibTest) enhancer.create();
        String res = proxy.sayHello(null);
        assertEquals("Hello Tom!", res);
    }

    /**
     * 生成简单的bean
     */
    public void createBean() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);//set&get自动生成
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");
        Method getter = myBean.getClass().getMethod("getName");
        assertEquals("some string value set by a cglib", getter.invoke(myBean));
    }


    /**
     * 把任一bean转为map
     */
    public void beanMap() throws Exception {
        ArrayList bean = new ArrayList(10);
        BeanMap map = BeanMap.create(bean);
    }

    public static void main(String[] args) throws Exception {
        CglibTest test = new CglibTest();
        test.createBean();
    }
}
