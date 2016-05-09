package com.designpattern.strategy;

import com.sun.javafx.tools.packager.Log;

public class Boy {
    IStrategy iStrategy;

    public Boy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void changeStrategy(IStrategy iStrategy){
        Log.info("log");
        this.iStrategy = iStrategy;
    }

    public void chaseGirl(){
        Log.info("change");
        iStrategy.execute();
    }

}
