package com.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Boy01 implements Observer {

    @Override
    public void update(Observable observable, Object arg) {
        System.out.println("Boy01 添加了评论~");
    }
}
