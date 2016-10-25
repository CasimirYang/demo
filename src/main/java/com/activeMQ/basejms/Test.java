package com.activeMQ.basejms;

/**
 * Created by yjh on 16/10/17.
 */
public class Test {

    public static void main(String[] args) {
        Singleton emm = Singleton.INSTANCE;
        emm.bili22="aali";
        System.out.println(emm.bili22);
        System.out.println(emm.getIn("1"));
    }
}
