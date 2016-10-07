package com.designpattern.ChainOfResponsibility;

import org.junit.Test;

/**
 * Created by yjh on 16/10/7.
 */
public class ChainTest {

    private static Filter generateChain(){
        Filter filter1 = new Filter1();
        Filter filter2 = new Filter2();
        Filter filter3 = new Filter3();
        filter1.setNextFilter(filter2);
        filter2.setNextFilter(filter3);
        return filter1;
    }
    @Test
    public void test(){
        generateChain().doChain("my message");
    }
}
