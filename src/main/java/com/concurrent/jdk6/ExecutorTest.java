package com.concurrent.jdk6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * CExecutors Executor 的工厂和工具类
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(); //ThreadPoolExecutor
        executorService.execute(new Thread1()); //没有返回值
        executorService.submit(new Thread2()); //有返回值
        executorService.shutdown(); // ExecutorService会阻止了 JVM 的关闭, 需要手动关闭
        System.out.println("shutdown");
    }
}

class Thread1 extends Thread{
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
class Thread2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("111");
    }
}
