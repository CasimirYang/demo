package com.designpattern.proxy.dynamicproxy;


public class RealImage implements Image {

    private String filename = null;

    public RealImage(final String filename) {
        this.filename = filename;
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

}
