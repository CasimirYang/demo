package com.byteEnhance.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 限制：只能代理接口
 */
public class JDKTest {

    public interface Task {
        void setData(String data);
    }

    public static class TaskImpl implements Task {
        @Override
        public void setData(String data) {
            System.out.println(data+ " Data is saved");
        }
    }

    public static class MyInvocationHandler implements InvocationHandler {
        //obj 被代理类
        private Object obj;
        MyInvocationHandler(Object obj) {
            this.obj = obj;
        }
        //proxy: 代理类
        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            System.out.println("...Method Executing...");
            return m.invoke(obj, args);
        }
    }
    
    /**
     * 使用Proxy.newProxyInstance 构建一个代理：
     *          传入classLoader，接口，InvocationHandler
     */
    public static class ProxyFactory {
        static Object newInstance(Object ob) {
            return Proxy.newProxyInstance(ob.getClass().getClassLoader(),
                    new Class<?>[] { Task.class }, new MyInvocationHandler(ob));
        }
    }

    public static void main(String[] args) {
        Task task = (Task)ProxyFactory.newInstance(new TaskImpl());
        task.setData("Test");
    }

}
