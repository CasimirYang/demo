package com.activeMQ.basejms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjh on 16/10/17.
 */
public enum Singleton {
    INSTANCE;

    public Map<String, String> props;
    private String bili;
    public String bili22;

    //不能用public修饰
    public String getIn(String aa){
        return "sdf";
    }
}
