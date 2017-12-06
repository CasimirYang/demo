package com.concurrent.jdk6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * readLock 不会阻塞readLock, readLock 与writeLock 才会相互阻塞
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Workder(readWriteLock.readLock()));
        executor.execute(new Workder(readWriteLock.readLock()));
        executor.execute(new Workder(readWriteLock.writeLock()));
        executor.execute(new Workder(readWriteLock.readLock()));
        executor.shutdown();
    }

    public  static class Workder extends Thread{
        Lock lock;
        public Workder(Lock lock) {
            this.lock=lock;
        }

        @Override
        public void run() {
            System.out.println("do some work");
            try {
                lock.lock();
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("unlock");
            }
        }
    }
}
