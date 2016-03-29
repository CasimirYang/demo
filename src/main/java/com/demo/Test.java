package com.demo;

/**
 * Created by casimiryang on 2016/3/28.
 */
public class Test {
    public static void main(String[] args){
        GT<Integer> gti = new GT<Integer>();
        gti.var=1;
        GT<String> gts = new GT<String>();
        gts.var=2;
        System.out.println(gti.var);
    }
}
class GT<T>{
    public  int var=0;
    public void nothing(T x){}
}
