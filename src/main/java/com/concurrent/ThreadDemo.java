package com.concurrent;

import java.util.concurrent.CompletableFuture;

public class ThreadDemo {

    private int i;
    static ThreadDemo threadDemo;
    public ThreadDemo() {
        //this.i = i;
    }

    public int getI() {
        return i;
    }
    public static void getInstance(){
//        threadDemo = new ThreadDemo(1);
        System.out.println("getInstance"+threadDemo);
    }

//    public static void main(String[] args) {
//        CompletableFuture.runAsync(ThreadDemo::getInstance);
//        while (true){
//            System.out.println("------------------------------------------------------");
//            CompletableFuture.runAsync(()->
//                    System.out.println("instance:"+ThreadDemo.threadDemo)).join();
//            try {
//                Thread.sleep(200L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.gc();
//        }
//    }

//    public static class MyThread2 extends Thread{
//
//        @Override
//        public void run() throws InterruptedException{
//            throw new InterruptedException();
//        }
//    }
}
