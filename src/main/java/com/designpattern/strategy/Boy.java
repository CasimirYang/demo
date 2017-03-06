package com.designpattern.strategy;


import org.apache.commons.logging.Log;

import java.util.logging.Logger;

public class Boy {
    Logger logger = Logger.getLogger(Boy.class.getName());
    IStrategy iStrategy;

    public Boy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void changeStrategy(IStrategy iStrategy){
        logger.info("log");
        this.iStrategy = iStrategy;
    }

    public void chaseGirl(){
        logger.info("change");
        iStrategy.execute();
    }

}
