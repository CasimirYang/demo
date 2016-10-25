package com.demo;

/**
 * Created by yjh on 2016/10/24.
 */
public class Child extends Fat {
    {
        System.out.println("Child 构造");
    }
    static void fun(){
        System.out.println("Child static fun");
    }
    static {
        System.out.println("static 构造");
    }

    public Child() {
        System.out.println("Child 构造函数");
    }

    public static void main(String[] args) {
        new Child();
    }
}
