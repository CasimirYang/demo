package com.concurrent.jdk6;

import java.util.concurrent.Exchanger;

/**
 * Created by casimiryang on 2016/3/21.
 */
public class ExchangerTest {

    public static void main(String[] args){
        Exchanger<String> exchanger =  new Exchanger<>();

        Thread a =new Thread(new ExchangerRunnable(exchanger,"cas"),"n1");
        new Thread(new ExchangerRunnable(exchanger,"CASI"),"n2").start();
        a.start();
    }

}

class ExchangerRunnable implements Runnable{
    Exchanger<String> exchanger;
    String value;

    public ExchangerRunnable(Exchanger<String> exchanger, String value) {
        this.exchanger = exchanger;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            System.out.println("current thread name " + Thread.currentThread().getName() + " from value:" + value + " to " + exchanger.exchange(value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
