package com.strtus2;

import java.util.logging.Logger;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by yjh on 16/10/5.
 */
public class WelcomeUserAction {


    // all struts logic here
    public String execute() {

        Logger logger1 = Logger.getLogger("console");
        logger1.info("WelcomeUserAction execute-----:"+Thread.currentThread().getId());
        return SUCCESS;

    }


}
