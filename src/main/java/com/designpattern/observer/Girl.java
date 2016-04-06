package com.designpattern.observer;

import java.util.Observable;

/**
 * Created by casimiryang on 2016/4/6.
 */
public class Girl extends Observable{

    String moments;

    public void postMoments(String moments){
        this.moments = moments;
        setChanged(); //必须要
    }
}
