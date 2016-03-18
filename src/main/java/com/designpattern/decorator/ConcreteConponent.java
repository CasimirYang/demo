package com.designpattern.decorator;

/**
 * Created by casimiryang on 2015/7/13.
 */
public class ConcreteConponent implements IConponent {

    @Override
    public  void fun(){
        System.out.println("base role init");
    }
}
