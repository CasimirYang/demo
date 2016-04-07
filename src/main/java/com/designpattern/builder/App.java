package com.designpattern.builder;

import com.designpattern.builder.Hero.Builder;

import java.math.BigDecimal;

/**
 Builder模式（多个构造器参数时可显著改善可读性)

 原理：定义一个 static 类型的 内部类 Builder，并且Builder类内部的属性就是我们要赋值的属性
 --->通过各个方法把我们要赋的值封装到 Builder的对象中，返回 this，这样就可以使用链式的结构
 ---> 最后定义一个 build() 方法，利用封装了各个参数的 Builder 对象创建目标对象。
 */

public class App {
    public static void main(String args[]){
        Hero hero = new Builder().setATK(new BigDecimal(5)).setName("小悟饭").build();
        System.out.println(hero);
    }
}
