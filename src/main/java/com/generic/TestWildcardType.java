package com.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 范型限制了类型，为了获得最大限度的灵活性，在表示生产者或者消费者的输入参数上使用类型通配符类型。
 comparable<? extends T> 优先于comparable<T>
 comparable<? super T> 优先于comparable<T>

 生产者用extends ,消费者用super

 put方法放进去,get方法拿出来放到传入的集合中
 */
public class TestWildcardType<E> {
    public void pushAll(Iterable<E> src){ //这里的参数是生产者
        for (E e: src){
           //  push(e);
        }
    }

    public void getAll(Collection<E> dst){  //这里的参数是消费者
       // dst.addAll(pop());
    }

    // support wildcard type
    public void pushAllWithWildcard(Iterable<? extends E> src){
        for (E e: src){
            // push(e);
        }
    }
    public void getAllWithWildcard(Collection<? super E> dst){
        // dst.addAll(pop());
    }

    public static void main(String[] args) {
        TestWildcardType<Number> test = new TestWildcardType<>();
        test.pushAll(new ArrayList<Number>(1));
        //Number 可以放进去Integer 却放不进去,有些不合理
      //  test.pushAll(new ArrayList<Integer>(1));  //error ArrayList<Integer>不是ArrayList<Number> 子类型,所以这里有错
        test.pushAllWithWildcard(new ArrayList<Integer>(1)); //使用有限制的通配符可以有更好的适应性.

        //想拿出来放到ArrayList<Object> 失败
        test.getAll(new ArrayList<Number>(1));
      //  test.getAll(new ArrayList<Object>(1)); //error
        test.getAllWithWildcard(new ArrayList<Object>(1));
    }
}


