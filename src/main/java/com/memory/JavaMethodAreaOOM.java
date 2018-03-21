package com.memory;


import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class JavaMethodAreaOOM {

    /**
     * 循环引用：
     *  fun方法内 gc gc2 都是两个各种引用+循环引用，计数器:2
     *  fun方法外gc-1 gc2-1还存在循环引用
     */
    public void fun(){
        ReferenceCountingGC gc = new ReferenceCountingGC();
        ReferenceCountingGC gc2 = new ReferenceCountingGC();
        gc.instance=gc2;
        gc2.instance=gc;
    }

    /**
     * ReferenceQueue: 如果达到目标级别的引用到达，就放入ReferenceQueue中
     *  PhantomReference必须配合使用ReferenceQueue；
     *  WeakReference & SoftReference 也可以配合使用ReferenceQueue
     */
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        ReferenceQueue<Student> rq = new ReferenceQueue<>();
        Reference r = new PhantomReference<>(student,rq);
        System.out.println(r.get()); //get() 方法永远返回 null
        System.out.println(rq.poll()); //null: 还没回收，所以queue中没有
        student = null;
        System.gc();
        Thread.sleep(1000L);
        System.out.println(rq.poll()); //@6477463f: 回收后放入queue中

        Class<JavaMethodAreaOOM>  o = JavaMethodAreaOOM.class;
        o.getAnnotations();
    }

    static class Student{
        String name;
    }

    static class ReferenceCountingGC{
        ReferenceCountingGC instance;
    }
}
