package com.byteEnhance.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.pool.TypePool;

import java.lang.reflect.Field;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;

public class ByteBuddyTest {
    public  class Foo {
        String m() { return "foo"; }
    }

    public  class Bar {
        String m() { return "bar"; }
    }

    public void fun(){
        Class<?> type  = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .make()
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
    }

    public void updateMethod() throws NoSuchFieldException {
        ByteBuddyAgent.install();
       // Bar bar = new Bar();
       // Foo foo = new Foo();
        TypePool typePool = TypePool.Default.ofClassPath();
        new ByteBuddy()
                .redefine(typePool.describe("com.byteEnhance.bytebuddy.Foo2").resolve(), // do not use 'Bar.class'
                        ClassFileLocator.ForClassLoader.ofClassPath())
                //.name("bbll")
                .defineField("qux", String.class) // we learn more about defining fields later
                .make()
                .load(ClassLoader.getSystemClassLoader());
        Foo foo = new Foo();
        System.out.println(foo.m());
        Field field = Animal.class.getDeclaredField("qux");
        System.out.println(field);
    }


    public static void main(String[] args) throws NoSuchFieldException {
        ByteBuddyTest test = new ByteBuddyTest();
        test.updateMethod();
    }
}
