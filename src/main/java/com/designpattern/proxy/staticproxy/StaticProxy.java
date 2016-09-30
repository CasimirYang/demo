package com.designpattern.proxy.staticproxy;


/**
 * Created by yjh on 16/9/30.
 */
public class StaticProxy implements Image {

    private RealImage image = null;
    private String filename = null;

    public StaticProxy(final String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename); //代理控制创建
        }
        image.displayImage();
    }
}
