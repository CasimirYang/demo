package com.concurrent;

import java.util.concurrent.*;


/**
 * RecursiveAction 无返回值
 * RecursiveTask 有返回值
 * <p>
 * 扩展RecursiveTask 实现compute方法
 * <p>
 * invokeAll的N个任务中，其中N-1个任务会使用fork()交给其它线程执行，但是，它还会留一个任务自己执行
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {
    private Integer start;
    private Integer end;

    private ForkJoinDemo(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end.compareTo(start) == 0) {
            return 0;
        }
        //任务不多就直接做了，不再细分
        if ((end - start) <= 100) {
            return sum(start, end);
        } else { //任务多，再分子任务
            ForkJoinDemo subTask1 = new ForkJoinDemo(start, start + 100);
            ForkJoinDemo subTask2 = new ForkJoinDemo(start + 101, end);
            //invokeAll的N个任务中，其中N-1个任务会使用fork()交给其它线程执行，但是，它还会留一个任务自己执行
            invokeAll(subTask1, subTask2);
            try {
                return subTask1.get() + subTask2.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    private Integer sum(Integer start, Integer end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, 100000);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());  //设置处理数量
        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinDemo);
        System.out.println(result.get());
    }
}
