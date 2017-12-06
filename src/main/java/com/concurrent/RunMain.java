package com.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();


        //while (true){
            System.out.println("------------------------------------------------------");
//            CompletableFuture.runAsync(ThreadDemo::getInstance).runAsync(()->
//                    System.out.println("instance:"+ThreadDemo.threadDemo)).join();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.gc();
       // }
    }
}
