package com.generic;

import java.util.EmptyStackException;

/**
 * 对需要考虑类型的类考虑使用泛型类对类型进行限制
 */

//原始类
class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        elements[size++] = e;
    }

    public Object pop() {
        if (size==0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }
}

//不支持泛型数组的解决方法一，用E[] 声明，Object[]创建再强转
 class StackSupportGeneric<E> {
    private E[] elements; //E[] 声明
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

     @SuppressWarnings("unchecked")
     public StackSupportGeneric() {
        elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];  //用Object[]后再强转
    }

    public void push(E e) {
        elements[size++] = e;
    }

    public E pop() {
        if (size==0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
}

//推荐，ArrayList 也是这种实现
//不支持泛型数组的解决方法二，直接用Object[]声明创建，对数组元素强转为泛型E
class StackSupportGeneric2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackSupportGeneric2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (size==0)
            throw new EmptyStackException();
        E result = (E)elements[--size];
        elements[size] = null;
        return result;
    }
}