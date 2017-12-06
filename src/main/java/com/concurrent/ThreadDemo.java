package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *打印1到9这9个数字，由A线程先打印1，2，3，然后由B线程打印4,5,6，然后再由A线程打印7，8，9
 *
 * 三种实现方式
 */
public class ThreadDemo {

    Thread threadOne;
    Thread threadTwo;

    void lockSupport(){
         threadOne = new Thread(()->{
            System.out.println("1,2,3");
            LockSupport.unpark(threadTwo);
            LockSupport.park(threadOne);
            System.out.println("7,8,9");

        });
         threadTwo = new Thread(()->{
            LockSupport.park(threadTwo);
             System.out.println("4,5,6");
             LockSupport.unpark(threadOne);
        });
        threadOne.start();
        threadTwo.start();
    }

    //初始化可重入锁
    final Lock lock = new ReentrantLock();
    //第一个条件当屏幕上输出到3
    final Condition reachThreeCondition = lock.newCondition();
    final Condition reachSixCondition = lock.newCondition();

    void condition() throws InterruptedException {
        threadOne = new Thread(()->{
            try{
                lock.lock();
                System.out.println("1,2,3");
                reachThreeCondition.signal();
                try {
                    reachSixCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("7,8,9");
            }finally {
                lock.unlock();
            }
        });
        threadTwo = new Thread(()->{
            try{
                lock.lock();
                try {
                    reachThreeCondition.await();
                    System.out.println("4,5,6");
                    reachSixCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finally {
                lock.unlock();
            }
        });
        threadTwo.start();
        Thread.sleep(10L); //必须保证threadTwo 先阻塞等待
        threadOne.start();
    }


    void objectWait() throws InterruptedException {
        threadOne = new Thread(()->{
            synchronized (ThreadDemo.this){
                System.out.println("1,2,3");
                try {
                    ThreadDemo.this.wait(); //指定哪个同步监视器
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("7,8,9");
        });
        threadTwo = new Thread(()->{
            synchronized (ThreadDemo.this){ //先获取同步监视器
                System.out.println("4,5,6");
                ThreadDemo.this.notify();  //指定哪个同步监视器
            }
        });
        threadOne.start();
        Thread.sleep(10L); //必须保证threadTwo 先阻塞等待
        threadTwo.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//
//        }
        ThreadDemo demo = new ThreadDemo();
        //demo.lockSupport();
        demo.objectWait();

    }

}
