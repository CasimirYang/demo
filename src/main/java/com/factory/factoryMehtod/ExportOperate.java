package com.factory.factoryMehtod;

/**
 * 本质： 延迟到子类来选择实现

 */
public abstract class ExportOperate {

    public void export(){
        Iexport iexport = factoryMethod();
        iexport.exportFile();
    }

    protected abstract Iexport factoryMethod();
}
