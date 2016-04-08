package com.designpattern.strategy;

/**
 *
 * 策略模式：是指对象的某个行为，在不同的场景中，有不同的实现算法。
 *
 *
 * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 * 这就意味着客户端必须理解这些算法的区别。换言之，策略模式只适用于客户端知道算法或行为的情况。
 *
 *
 * 组成：
 ●　　环境(Context)角色：持有一个Strategy的引用。
 ●　　抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 ●　　具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。

 */
public class Client {

    public static void main(String args[]){
        Boy boy = new Boy(new Strategy01());
        boy.chaseGirl();

        boy.changeStrategy(new Strategy02()); //改变策略
        boy.chaseGirl();
    }
}
