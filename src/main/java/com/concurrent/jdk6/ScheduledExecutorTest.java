package com.concurrent.jdk6;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjh on 16/10/11.
 */
public class ScheduledExecutorTest {
    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule();


        //ScheduledThreadPoolExecutor
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.schedule(new Scheduler1(),5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
class Scheduler1 extends Thread{
    @Override
    public void run() {
        System.out.println("111");
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
