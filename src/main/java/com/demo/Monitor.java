package com.demo;

import scala.Int;

public class Monitor {



     static void createBusyThread(){
         int a=2,b=1;
         for (int i = 0; i < 2; i++) {
             new Thread(() -> {
                 synchronized (Integer.valueOf(a)){
                     try {
                         Thread.sleep(1000L);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     synchronized (Integer.valueOf(b)){

                         System.out.println(a+b);
                     }
                 }
             },"testBusyThread1").start();
             new Thread(() -> {
                 synchronized (Integer.valueOf(b)){
                     try {
                         Thread.sleep(1000L);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     synchronized (Integer.valueOf(a)){
                         System.out.println(a+b);
                     }
                 }
             },"testBusyThread2").start();
         }
    }

    public static void main(String[] args) {
        createBusyThread();
    }
}
