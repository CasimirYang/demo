package com.designpattern.strategy;


public class Boy {
    IStrategy iStrategy;

    public Boy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void changeStrategy(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }

    public void chaseGirl(){
        iStrategy.execute();
    }

}
