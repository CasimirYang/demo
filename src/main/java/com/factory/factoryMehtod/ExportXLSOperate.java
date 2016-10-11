package com.factory.factoryMehtod;

/**
 * Created by yjh on 16/10/7.
 */
public class ExportXLSOperate  extends ExportOperate {

    @Override
    protected Iexport factoryMethod() {
        return new ExportXLS();
    }
}