package com.demo;


public enum MyEnum {
    RRD("red",1),BlACK("black",2);

    //自定义方法
    void fun() {
        System.out.println("MyEnum fun");
    }

    //覆盖构造方法
    MyEnum(String name ,int index) {
        System.out.println("MyEnum init: "+name+" index:"+ index);
    }
}
