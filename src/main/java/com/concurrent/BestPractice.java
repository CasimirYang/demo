package com.concurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 停止标识之
 *   先判断后执行 存在竞态条件问题
 *   :有可能判断后执行业务代码前状态被改变
 */
public class BestPractice extends Thread {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(11);
    //volatile 保证可见性
    private volatile boolean finished = false;

    public void stopMe() {
        System.out.println(Thread.currentThread());
        finished = true;
        //当阻塞于wait()，sleep()，队列时，线程不能立刻检测到停止标识。因此同时调用interrupt()
        interrupt();
    }

    @Override
    public void run() {
        while (!finished) {
            //如果是阻塞的任务需要可interrupt 或 timeOut 使得可检测停止标识
            //如对于blocking IO的处理，尽量使用InterruptibleChannel来代替
            // do work
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println( Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BestPractice bestPractice = new BestPractice();
        bestPractice.start();
        Thread.sleep(100L);
        bestPractice.stopMe();

        Thread.sleep(3000L);
        System.out.println("main");
    }
}

