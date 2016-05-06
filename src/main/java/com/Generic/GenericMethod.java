package com.Generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 泛型方法
 */
public class GenericMethod {
    public static void main(String args[]){
        List<Number> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List list3 = new ArrayList();
       /// sort(list);  //error Number没有实现Comparable
        sort(list2);
        sort(list3);   //可以用原生态类，在语法上没有错误，只是在运行时容易出错，因为没有保证类型
        list.add(12);
        (new Test<Number>()).fun(list);
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Object[] a = list.toArray();
        Arrays.sort(a);
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }
    }

    static class Test<T>{
        public void fun(List<? extends T> list){
            List<T> list2 = (List<T>)list;
            Object param = "asd";
            list2.add((T)param);
            System.out.println(list2);
        }
    }
}
