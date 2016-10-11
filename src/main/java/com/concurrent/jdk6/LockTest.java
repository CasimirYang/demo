package com.concurrent.jdk6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new ThreadOne(lock));
        executor.execute(new ThreadOne(lock));
        executor.execute(new ThreadOne(lock));
        executor.shutdown();
    }

    public  static class ThreadOne extends Thread{
        Lock lock;
        public ThreadOne(Lock lock) {
            this.lock=lock;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            lock.lock();
            System.out.println("do some work");
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("unlock");
        }
    }
}
