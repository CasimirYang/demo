package com.designpattern.proxy.staticproxy;

import com.designpattern.proxy.staticproxy.Image;

/**
 * Created by yjh on 16/9/30.
 */
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


