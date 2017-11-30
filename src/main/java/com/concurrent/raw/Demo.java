package com.concurrent.raw;


import com.concurrent.ThreadDemo;
import com.google.common.collect.ImmutableList;

import javax.print.attribute.UnmodifiableSetException;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *Demo的线程安全交给ConcurrentHashMap来处理
 * 包装类 Collections.unmodifiableXXX 和 ImmutableXXX只是防止容器被修改
 * 而不能防止调用者修改保存在容器中的对象
 */
public class Demo {
    static WeakHashMap<ThreadDemo,String> weakHashMap = new WeakHashMap<>(2);

    public static void fun(){
        ThreadDemo threadDemo = new ThreadDemo();
        weakHashMap.put(threadDemo,"value");
        System.out.println("fun"+weakHashMap.size());
    }

    public static void main(String[] args) throws InterruptedException {
        System.gc();

        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().isInterrupted());
            ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(e);
            }
        });
        thread.start();
        Thread.sleep(4000L);
        thread.interrupt();
        Thread.sleep(4000L);


        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        //copyOnWriteArrayList.

        //ImmutableXXX.copyOf()        guava
        //Collections.unmodifiableXXX  jdk
        //Collections.synchronizedXXXX jdk

        //Thread.sleep(2000L); //wait gc
        //System.out.println(weakHashMap.size());
    }

    //final保证对应返回引用之前初始化完成
    private final ConcurrentHashMap<String,String> locations;
    private final Map<String,String> unmodifiableMap;

    public Demo(Map<String, String> map) {
        this.locations = new ConcurrentHashMap<>(map);
        //浅复制
        this.unmodifiableMap = Collections.unmodifiableMap(new HashMap<>(map));
        //this.unmodifiableMap = Collections.unmodifiableMap(map);
    }

    public Map<String, String> getLocations() {
        return unmodifiableMap;
    }
    public String getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id) {
        locations.replace(id,"CA");
    }

    /**
     * 虽然两个组件都是线程安全的，但不是独立的，所以委托给组件不能保证线程安全;
     * 需要setLower , setUpper 都进行同步才线程安全
     */
    private final AtomicInteger lower = new AtomicInteger(1);
    private final AtomicInteger upper = new AtomicInteger(2);

    public void setLower(int i){
        if(i>upper.get()){ //先检查再执行  not safe
            throw new IllegalArgumentException("lower>upper");
        }
        lower.set(i);
    }

    public void setUpper(int i){
        if(i<lower.get()){  //先检查再执行  not safe
            throw new IllegalArgumentException("lower<upper");
        }
        upper.set(i);
    }

}
