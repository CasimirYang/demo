package com.concurrent.jdk6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * java.util.concurrent 包里的 BlockingQueue 接口表示一个线程往里边放，另外一个线程从里边取的一个 BlockingQueue。
 *
 *如果队列到达了其临界点，负责生产的线程将会在往里边插入新对象时发生阻塞。它会一直处于阻塞之中，直到负责消费的线程从队列中拿走一个对象。
 负责消费的线程将会一直从该阻塞队列中拿出对象。如果消费线程尝试去从一个空的队列中提取对象的话，这个消费线程将会处于阻塞之中，直到一个生产线程把一个对象丢进队列。

 */
public class BlockingQueueTest {


    public static void main(String[] args){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable{
    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(1);
            Thread.sleep(1000);
            blockingQueue.put(100);
            Thread.sleep(1000);
            blockingQueue.put(1000_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("1："+blockingQueue.take());
            System.out.println("2："+blockingQueue.take());
            System.out.println("3："+blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}