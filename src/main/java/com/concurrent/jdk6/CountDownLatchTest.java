package com.concurrent.jdk6;

import java.util.concurrent.CountDownLatch;

/**
 * 并发构造，它允许一个或多个线程等待一系列指定操作的完成。
 * 它允许一个或多个线程等待CountDownLatch实例的的countDown（）为0 后再运行。
 CountDownLatch 以一个给定的数量初始化。countDown() 每被调用一次，这一数量就减一。通过调用countDownLatch对象 await() 方法之一，线程可以阻塞等待countDownLatch对象的这一数量到达零。
 */
public class CountDownLatchTest {

    void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);

        for (int i = 0; i < 10; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish
    }

    private void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {} // return;
    }

    void doWork() {
        System.out.println("doWork");
    }
}




