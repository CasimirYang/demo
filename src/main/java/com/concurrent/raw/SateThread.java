package com.concurrent.raw;

import java.io.IOException;

/**
 * 一般所说的 safeThread 是方法级别的synchronized， 比如同一时间内只有一个线程可以进入StringBuffer 的 append 方法， 而不是给这个对象上锁。
 * 如果两个线程都给对象 stringBuffer 上排它锁，比如：
 *   synchronized (stringBuffer){
            stringBuffer.append("thread "+thread.currentThread());
        }
   输出：
   thread1: thread1
   thread2：thread1 thread2

 因为他们修改的是全局变量，虽然错开了同步修改，但还是都对原对象进行了修改。要线程内部的值独立，应该用非全局变量。
 *
 */


public class SateThread {

    static StringBuffer stringBuffer = new StringBuffer("init ");

    static void fun() {
        try {
            stringBuffer.append("thread 1");
            Thread.sleep(1000);
            System.out.println("inner thread1:" + Thread.currentThread().getName() + " value:" + stringBuffer.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void fun2() {
        try {
            stringBuffer.append("thread 2");
            Thread.sleep(1000);
            System.out.println("inner thread2:" + Thread.currentThread().getName() + " value:" + stringBuffer.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                fun();
                System.out.println("thread1:" + Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                fun2();
                System.out.println("thread2:" + Thread.currentThread().getName());
            }
        };
        thread.start();
        thread2.start();
    }
}
