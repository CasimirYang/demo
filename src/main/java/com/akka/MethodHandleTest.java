package com.akka;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    static class ClassA{
        public void fun(String param){
            System.out.println(param);
        }
    }
    static class ClassB{
        public void fun(String param){
            System.out.println(param);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis()%2==0?new ClassA():new ClassB();
        getMH(obj).invokeExact(obj.getClass().getSimpleName());
    }

    /**
     * MethodType   代表方法类型（包括参数类型和返回类型）
     * MethodHandle 代表符合要求的某个方法
     * 调用虚方法，按照Java语言的规则，方法的第一个参数是隐式的 this,代表方法的执行者,
     * 之前放在参数列表中传递,现在使用bindTo()
     */
    static MethodHandle getMH(Object reveiver)
            throws NoSuchMethodException, IllegalAccessException {
        MethodType mh = MethodType.methodType(void.class,String.class);
        MethodHandle methodHandle = MethodHandles.lookup()
                .findVirtual(reveiver.getClass(), "fun",mh);
        return methodHandle.bindTo(reveiver);
    }
}
