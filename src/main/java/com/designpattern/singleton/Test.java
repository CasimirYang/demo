package com.designpattern.singleton;

/**
 * Created by yjh on 2016/10/25.
 */
public class Test {
    public static void main(String[] args) {
        Mysingleton mysingleton = Mysingleton.singleton;
        mysingleton.ff();
    }
}
