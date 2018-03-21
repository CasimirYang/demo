package com.byteEnhance.javassist;

import com.byteEnhance.bytebuddy.Animal;
import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistTest {

    public static class Point {
        int x, y;
    }

    public static void main(String[] args) throws NotFoundException,
            CannotCompileException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CtClass cc = ClassPool.getDefault().get("com.byteEnhance.bytebuddy.Animal");
        CtMethod m = CtNewMethod.make(
                "public int getAge(int dx) { return dx; }",
                cc);
        cc.addMethod(m);
        cc.toClass(); //必须保证这是第一次加载
        Animal foo2 = new Animal();
        Method method = foo2.getClass().getDeclaredMethod("getAge",int.class);
        System.out.println(method.invoke(foo2,12));
    }
}
