package com.concurrent.raw;

/**
 * ThreadLocal并非一个线程，而是一个线程局部变量。
 * 它的作用就是为使用该变量的线程都提供一个变量值的副本，每个线程都可以独立的改变自己的副本，而不会和其他线程的副本造成冲突。

 InheritableThreadLocal 可以在创建一个新线程的时候把现线程的 ThreadLocal 复制一份过去。 线程启动之后各自独立。
 */

public class ThreadLocalTest {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public  static void main(String args[]){
        threadLocal.set(123);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread = " + threadLocal.get());  //MyThread = null
            }
        });
        thread.start();
        System.out.println("main = " + threadLocal.get()); //main = 123
    }
}