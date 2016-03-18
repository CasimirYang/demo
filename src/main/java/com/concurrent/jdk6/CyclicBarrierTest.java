package com.concurrent.jdk6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 通过调用 CyclicBarrier 对象的 await() 方法，n个线程可以实现互相等待。一旦 N 个线程在等待该 CyclicBarrier 实例达成，所有线程将被释放掉去继续运行
 (比如每个线程都是一个运动员，在起跑线都准备好后 CyclickBarrier 就可以一次放行，让所有运动员都开始)
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("RunningMan all ready: "+Thread.currentThread().getName());
            }
        };
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,barrierAction); //这里 barrierAction可以null, 跑barrierAction 的线程不固定，是barrier里面的线程之一。
        for (int i = 0; i < 5; i++) {
            new Thread(new RunningMan(cyclicBarrier)).start();
        }
    }
}

class RunningMan implements Runnable {
    CyclicBarrier cyclicBarrier;

    public RunningMan(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Ready: "+Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {}
        System.out.println("Begin to run: "+Thread.currentThread().getName());
    }
}

