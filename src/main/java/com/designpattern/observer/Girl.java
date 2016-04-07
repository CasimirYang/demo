package com.designpattern.observer;

import java.util.Observable;

public class Girl extends Observable{

    String moments;

    public void postMoments(String moments){
        this.moments = moments;
        setChanged(); //必须要
    }
}
