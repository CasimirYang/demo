package com.designpattern.ChainOfResponsibility;

/**
 * Created by yjh on 16/10/7.
 */
public class Filter3 extends  Filter {

    @Override
    protected void doFilter(String message) {
        System.out.println(this.getClass().getName()+" handle "+message +" in chain.");
    }
}
