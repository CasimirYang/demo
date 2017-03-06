package com.concurrent.jdk6;

import java.io.IOException;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 注入其中的元素必须实现 java.util.concurrent.Delayed 接口
 * deplay 设置的不是expire 时间， 设置的是延迟多久才可以用的时间
 * 传递给 getDelay 方法的 getDelay 实例是一个枚举类型，它表明了将要延迟的时间段。TimeUnit 枚举
 */
public class DelayQueueTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        DelayedDemo delayedDemo = new DelayedDemo(5000); //deplay 设置的不是expire 时间， 设置的是延迟多久才可以执行的时间
        for (int i = 0; i < 10; i++) {
            delayQueue.put(delayedDemo);
        }
        while (true){
            System.out.println(delayQueue.take()); // 五秒后才可以使用
        }
    }


}

class DelayedDemo implements Delayed{
    private long delay;
    public DelayedDemo( long delay) {
        this.delay = delay+ System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay- System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}