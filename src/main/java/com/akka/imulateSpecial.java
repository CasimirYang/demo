package com.akka;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class imulateSpecial {
    static class ClassA{
        public void fun(){
            System.out.println("A");
        }
    }
    static class ClassB extends ClassA{
        public void fun(){
            System.out.println("B");
        }
    }

/**
* 1.findSpecial()限制specialCaller == lookupClass()
* 2.MethodHandle用于模拟invokespecial时，遵守invokespecial指令:
 *      从findSpecial()方法的最后一个参数（“specialCaller”）开始搜索方法
*/
    static class ClassC extends  ClassB{
        void dowork() throws Throwable {
            MethodType mh = MethodType.methodType(void.class);
              MethodHandle methodHandle = MethodHandles.lookup()
                      .findSpecial(getClass(), "fun",mh,getClass());
            //methodHandle.bindTo(this).invoke();//方法的第一个参数是隐式的this;等价下面的
            methodHandle.invoke(this);
        }
    }

    public static void main(String[] args) throws Throwable {
        ClassC c = new ClassC();
        c.dowork(); //B
    }
}
