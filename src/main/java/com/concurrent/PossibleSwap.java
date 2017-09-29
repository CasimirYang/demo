package com.concurrent;

/**
 * Created by Lenovo on 2017/8/14.
 */
public class PossibleSwap {
    int a = 1, b = 2;
    synchronized void  to() {
        a = 3;
        b = 4;
    }
    void fro() {
        if(a==1 && b==4){
            System.out.println(a+","+b);
            //1,1 或者 2，2 或者 2，1
        }
}

    public static void main(String[] args) throws InterruptedException {
        while (true){
            final PossibleSwap swap = new PossibleSwap();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    swap.to();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    swap.fro();
                }
            });
            t2.start();
            t1.start();

            t1.join();
            t2.join();
            System.gc();
        }
    }
}
