package com.concurrent;

public class BadLockOnInteger implements Runnable {

    public static Integer i = 0;

    /**
     * Integer 是不可变的，所以锁的不是同一个对象;
     * 一般 synchronized 要求锁的对象是final的，可以避免这个问题
     */
    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            synchronized (i){ //synchronized non-final may useless
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new BadLockOnInteger());
        Thread thread2 = new Thread(new BadLockOnInteger());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i); //1000~2000
    }
}
