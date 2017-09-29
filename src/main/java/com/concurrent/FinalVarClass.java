package com.concurrent;

/**
 * Created by Lenovo on 2017/8/14.
 */
public class FinalVarClass {

    public int a;
    public int c;
    public int d;
    public int b = 0;
    static FinalVarClass co;

    public FinalVarClass() {
        a = 1;
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c=123;
        d=123;
        b = 1;
    }

   // 线程1创建FinalVarClass对象 co
    public static void create() {
        co = new FinalVarClass();
    }

    //线程2访问co对象的a，b属性
    public static void vistor() {
        if (co != null) {
            if(co.b==0){
                System.out.println(co.a);//这里返回的一定是1,a一定初始化完成
                System.out.println(co.b);//这里返回的可能是0，因为b还未初始化完成
                System.out.println("--------------------------");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    FinalVarClass.create();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    FinalVarClass.vistor();
                }
            });
            t2.start();
            t1.start();

            t1.join();
            t2.join();
            FinalVarClass.co = null;
            System.gc();
        }
    }
}
