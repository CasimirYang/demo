package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 因为null值可以强制转换为任何java类类型,(String)null也是合法的。但null强制转换后是无效对象，
 * 其返回值还是为null，而static方法的调用是和类名绑定的，不借助对象进行访问所以能正确输出。
 */
public class Null {
    static void fun(char[] a){
        a[0]='c';
    }

    static void fun2(String a){
        a="ccc";
    }

    static void fun3(int a){
        a=12;
    }

    public static void haha(){
        System.out.println("haha");
    }
    public static void main(String[] args) {
       // ((Null)null).haha();
        String ab = "cc";
        fun2(ab);
        System.out.println(ab);
        char[] a= new char[3];
        a[0]='q';
        a[1]='a';
        fun(a);
        System.out.println(a); //形参（栈上新的一个）， 传递的是引用的复制值，而不是原来那个
        int i = 1;
        fun3(i);
        System.out.println(i);

    }

}