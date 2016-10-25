package com.designpattern.singleton;

import java.util.Map;

/**
 * Created by yjh on 2016/10/25.
 */
public enum Mysingleton {
    singleton;
    private String name;
    public int id;
    public Map map;
    static{
        System.out.println("run static cons");
    }
    {
        System.out.println("run cons");
    }
   private void fun(){

   }
    public void ff(){
        System.out.println("run ff");
    }

//    run cons
//    run static cons
//    run ff
}
