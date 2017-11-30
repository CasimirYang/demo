package com.concurrent;

import java.util.concurrent.*;

/**
 * 原理:内部通过阻塞队列+FutureTask，实现了任务先完成可优先获取到，即结果按照完成先后顺序排序。
 */
public class CompletionServiceDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable callable = () -> {
            String a ="";
            return "";
        };
        CompletionService<String> completionService = new ExecutorCompletionService<>
                (executorService,new ArrayBlockingQueue<Future<String>>(10));
        completionService.submit(() -> "6");
        completionService.submit(() -> "5");
        completionService.submit(() -> {
            Thread.sleep(30L);
            return "4";
        });
        completionService.submit(() -> "3");
        completionService.submit(() -> "2");
        completionService.submit(() -> "1");

        for (int i = 0; i < 6; i++) {
            try {
                Future<String> future = completionService.take();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
