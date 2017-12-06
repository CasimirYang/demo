package com.concurrent;

public class MyWaitNotify {

    Object lock = new Object();


    /**
     * 如果 doNotify 在 doWait前先执行，wait会等不到notify消息
     */
    boolean wasSignalled = false;
    public void doWait(){
        synchronized(lock){
            if(!wasSignalled){
                try{
                    lock.wait();
                    //do work
                } catch(InterruptedException e){ }
            }
        }
    }

    public void doNotify(){
        synchronized(lock){
            wasSignalled = true;
            lock.notify();
        }
    }
}
