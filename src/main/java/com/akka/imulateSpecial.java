package com.akka;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
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
     * findSpecial()限制specialCaller == lookupClass(),即要求specialCaller跟当前类一致;所以只能在specialCaller中使用findSpecial
     *  MethodHandle用于模拟invokespecial时，遵守invokespecial指令的限制——从findSpecial()方法的最后一个参数（“specialCaller”）开始搜索方法
     */
    static class ClassC extends  ClassB{
        void dowork() throws Throwable {
            MethodType mh = MethodType.methodType(void.class);
              MethodHandles.lookup().findSpecial(getClass(),
                      "fun",mh,getClass()).invoke(this);
        }
    }

    /**
     * invokespecial指令相同的限制——它只能调用到传给findSpecial()方法的最后一个参数（“specialCaller”）的直接父类的版本。
     */
    public static void main(String[] args) throws Throwable {
        ClassC c = new ClassC();
        c.dowork(); //B
    }

}
