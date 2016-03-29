package com.concurrent.jdk6;

import java.util.concurrent.Semaphore;

/**
 java.util.concurrent.Semaphore 类是一个计数信号量。这就意味着它具备两个主要方法：
 acquire()
 release()
 计数信号量由一个指定数量的 "许可" 初始化。每调用一次 acquire()，一个许可会被调用线程取走。每调用一次 release()，一个许可会被返还给信号量。因此，在没有任何 release() 调用时，最多有 N 个线程能够通过 acquire() 方法，N 是该信号量初始化时的许可的指定数量。
 信号量主要有两种用途：
 保护一个重要(代码)部分防止一次超过 N 个线程进入。（进入代码块前，先acquire() ）
 在两个线程之间发送信号。 (一个线程acquire() 等待另一个线程release() )
 多个线程的acquire()，默认获取permit 的先后顺序不不保证的。如果第一个线程在等待一个许可时发生阻塞，而第二个线程前来索要一个许可的时候刚好有一个许可被释放出来，那么它就可能会在第一个线程之前获得许可。（可配置）
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore available = new Semaphore(2, true);
        new Thread(new RequireRunnable(available)).start();
        new Thread(new RequireRunnable(available)).start();
    }
}

class RequireRunnable implements Runnable{
    Semaphore available;

    public RequireRunnable(Semaphore available) {
        this.available = available;
    }

    @Override
    public void run() {
        System.out.println("current thread name" + Thread.currentThread().getName() + "before acquire");
        try {
            available.acquire();
            System.out.println("current thread name" + Thread.currentThread().getName() + "after acquire");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        available.release();
        System.out.println("current thread name" + Thread.currentThread().getName() + "after release");
    }
}