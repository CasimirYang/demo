package com.demo;

import com.byteEnhance.bytebuddy.ByteBuddyTest;

import java.io.IOException;
import java.io.InputStream;

/**
 *	equals， isAssignableFrom，isInstance等判断相关“类相等”，首先需要是同一个类加载器。
 */
public class ClassLoadTest {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException {

        ClassLoader myLoader = new ClassLoader() {

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                InputStream inputStream = getClass().getResourceAsStream
                        (name.substring(name.lastIndexOf(".")+1)+".class");
                if(inputStream == null){
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[inputStream.available()];
                    inputStream.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name,b,0,b.length);
            }
        };
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Object obj = myLoader.loadClass("com.demo.ClassLoadTest").newInstance();
            Object obj2 = myLoader.loadClass("com.demo.ClassLoadTest").newInstance();
            System.out.println(obj.getClass()); //ClassLoadTest
            System.out.println(obj2);
            System.out.println(obj instanceof com.demo.ClassLoadTest); //false
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
