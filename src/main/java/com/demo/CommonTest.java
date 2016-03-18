package com.demo;

/**
 * Created by casimiryang on 2016/1/7.
 */
public class CommonTest {

    public static void main(String[] args){
      while (true){
            fun();
        }
    }
static  void fun(){
    Demo1 demo1 = new Demo1();
    new Thread(demo1).start();
}

}

class  Demo1 implements Runnable{
    @Override
    public void run() {
        System.out.println("---");
       // fun_D();
        System.out.println("___---___"+Thread.currentThread().getName());
    }
    static  void fun_D(){
        Demo2 demo2 = new Demo2();
        new Thread(demo2).start();
    }
}


class  Demo2 implements Runnable{
    @Override
    public void run() {
        System.out.println("++++++"+Thread.currentThread().getName());
        //fun_D();
    }
    static  void fun_D(){
        Demo1 demo2 = new Demo1();
        new Thread(demo2).start();
    }
}