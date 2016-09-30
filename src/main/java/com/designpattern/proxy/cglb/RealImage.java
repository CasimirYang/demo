package com.designpattern.proxy.cglb;

/**
 * Created by yjh on 16/9/30.
 */
public class RealImage {

    private String filename = null;


    public RealImage(final String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}
