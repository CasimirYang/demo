package com.factory.factoryMehtod;

/**
 * Created by yjh on 16/10/7.
 */
public class Test {

    @org.junit.Test
    public void test(){
        ExportOperate exportOperate = new ExportPDFOperate();
        exportOperate.export();
    }
}
