package com.demo;

/**
 * Created by yjh on 2016/10/24.
 */
public class Fat {
    {
        System.out.println("fat 构造");
    }
    static void fun(){
        System.out.println("fat static fun");
    }

    public Fat() {
        System.out.println("fat 构造函数");
    }
    static {
        System.out.println("fat static 构造");
    }
}
