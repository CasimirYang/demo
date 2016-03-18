package com.designpattern.decorator;

/**
 * Created by casimiryang on 2015/7/13.
 */
public class Decorator_2 extends Decorator {

    public Decorator_2(IConponent conponent) {
        this.conponent = conponent;
    }
    @Override
    public void fun() {
        conponent.fun();
        System.out.println("装备护甲");
    }
}
