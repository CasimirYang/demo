package com.concurrent.raw;

import java.util.concurrent.atomic.*;
import java.util.function.LongBinaryOperator;

public class AtomicTest {

    /**
     * AtomicIntegerArray类需要注意的是，数组value通过构造方法传递进去，然后AtomicIntegerArray
      会将当前数组复制一份，所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响到传入的数组。
     */
    void atomicArray(){
        int[] value = new int[] { 1, 2 };
        AtomicIntegerArray ai = new AtomicIntegerArray(value);
        ai.compareAndSet(0,1,100);
        System.out.println(ai.get(0));  //100
        System.out.println(value[0]);   //1    原数组没有修改
    }

    void atomicFieldUpdater(){
        User user = new User(1);
        AtomicIntegerFieldUpdater<User> atomicUpdater = AtomicIntegerFieldUpdater.
                newUpdater(User.class,"no");
        atomicUpdater.compareAndSet(user,1,2);
        System.out.println(user.no);
    }

    void atomicInteger(){
        int i = 1;
        AtomicInteger ai = new AtomicInteger(i); //int 不是引用，原i没有改变
        ai.compareAndSet(1,100);
        System.out.println(ai.get()); //100
        System.out.println(i);  //1
    }

    /**
     *使用标识解决ABA问题
     * AtomicStampedReference使用int做标识；AtomicMarkableReference使用boolean标识
     */
    void atomicPeference(){
        User user = new User(1);
        User anotherUser = new User(2);
        AtomicStampedReference<User> stampedReference = new AtomicStampedReference<>(user,0);
        stampedReference.compareAndSet(user,anotherUser,0,3);
        System.out.println(stampedReference.getStamp()); //3

        AtomicMarkableReference<User> markableReference = new AtomicMarkableReference<>(user,true);
        markableReference.compareAndSet(user,anotherUser,true,false);
        System.out.println(markableReference.isMarked()); //false
    }

    void adder(){
        /**
         *在高竞争做累计时 LongAdder/DoubleAdder 性能比 AtomicLong/AtomicDouble 更好
         */
        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
        longAdder.increment();
        System.out.println(longAdder.sum());

        DoubleAdder doubleAdder = new DoubleAdder();
        doubleAdder.add(1.2f);
        doubleAdder.add(-2.3f);
        System.out.println(doubleAdder.sum());

        /**
         * LongAccumulator/DoubleAccumulator需要自己控制算法
         * LongAdder/DoubleAdder 是 LongAccumulator/DoubleAccumulator 的一种特例
         */
        LongBinaryOperator accumulatorFunction = (left, right) -> left+right;
        LongAccumulator longAccumulator = new LongAccumulator(accumulatorFunction,1);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get()); //4
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        atomicTest.atomicPeference();
    }

    static class User{
        volatile int no = 1;

        public User(int no) {
            this.no = no;
        }
    }
}
