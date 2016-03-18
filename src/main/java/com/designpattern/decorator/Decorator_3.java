package com.designpattern.decorator;

/**
 * Created by casimiryang on 2015/7/13.
 */
public class Decorator_3  extends  Decorator{

    public Decorator_3(IConponent conponent) {
        this.conponent = conponent;
    }

    @Override
    public void fun() {
        conponent.fun();
        System.out.println("装备饰品");
    }
}
