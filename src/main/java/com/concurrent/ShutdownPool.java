package com.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

public class ShutdownPool {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final Set<Runnable> taskCancallledAtShutdown = new HashSet<>();
    public static void main(String[] args) throws InterruptedException {

        execute(()->{

        });
    }

    /**
     * 存在无法避免的竞态条件，在执行任务完成后将任务标记未结束的最后一个指令前任务有可能被关闭
     * 所以需要任务幂等处理
     */
    public static void execute(final Runnable runnable){
        executorService.submit(()->{
            try {
                //to work
                runnable.run();
            }finally {
                if(executorService.isShutdown()
                        && Thread.currentThread().isInterrupted()){
                    taskCancallledAtShutdown.add(runnable);
                }
            }
        });
    }

    Logger logger = LoggerFactory.getLogger("");

    BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    /**
     * 先判断再运行
     * 因为在shutdown后队列有可能满,需要timeout防止阻塞而不能回收
     */
    volatile boolean shutdown;
    volatile Thread currentThread;
    public void log(String msg){
        if(!shutdown){
            try {
                boolean bool = queue.offer(msg,1, TimeUnit.SECONDS);
                if(bool){
                    logger.info(msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
