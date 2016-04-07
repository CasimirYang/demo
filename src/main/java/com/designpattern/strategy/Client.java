package com.designpattern.strategy;

/**
 *
 * 策略模式：是指对象的某个行为，在不同的场景中，有不同的实现算法。
 *
 *
 * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 * 这就意味着客户端必须理解这些算法的区别。换言之，策略模式只适用于客户端知道算法或行为的情况。
 *
 */
public class Client {

    public static void main(String args[]){
        Boy boy = new Boy(new Strategy01());
        boy.chaseGirl();

        boy.changeStrategy(new Strategy02()); //改变策略
        boy.chaseGirl();
    }
}
