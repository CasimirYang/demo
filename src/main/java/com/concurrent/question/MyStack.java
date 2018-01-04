package com.concurrent.question;

import java.util.ArrayList;
import java.util.List;


/**
 *wait方法可以分为三个操作：
 （1）释放锁并阻塞
 （2）等待条件cond发生
 （3）获取通知后，竞争获取锁

 状况1：
     1.  假设有三个线程： A,B,C.  A 负责放入数据到list,就是调用push操作， B,C分别执行Pop操作，移除数据。
     2.  首先B先执行，于pop中的wait()方法处，进入waiting状态，进入等待队列，释放锁
     3.  A首先执行放入数据push操作到List，在调用notify()之前； 同时C执行pop()，由于synchronized，被阻塞，进入Blocked状态
     4.  A线程调用notify()，唤醒等待中的线程A。
     5.  如果此时， C获取到基于对象的锁，则优先执行，执行pop方法，获取数据，从list移除一个元素。
     6.  然后，A获取到竞争锁，A中调用list.remove(list.size() - 1)，则会报数据越界exception。

 状况2：
     虚假唤醒:即在多处理器的系统下发出wait的程序有可能在没有notify唤醒的情形下苏醒继续执行。

 解决：
     1.使用可同步的数据结构来存放数据，比如LinkedBlockingQueue之类。由这些同步的数据结构来完成繁琐的同步操作
     2. wait 搭配while使用
 */
public class MyStack {
    private List<String> list = new ArrayList<>();

    public synchronized void push(String value) {
            list.add(value);
            notify();
    }

    public synchronized String pop() throws InterruptedException {
            if (list.size() <= 0) {
                wait(); //被唤醒的时候不一定同时能获取到锁
            }
            return list.remove(list.size() - 1);
    }
}
