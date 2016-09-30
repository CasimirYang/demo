package com.designpattern.proxy;

import com.designpattern.proxy.cglb.CglibProxy;
import com.designpattern.proxy.dynamicproxy.DynamicProxy;
import com.designpattern.proxy.staticproxy.StaticProxy;
import org.junit.Test;

/**
 * Created by yjh on 16/9/30.
 */
public class Client {

    @Test
    public void testProxy(){
        StaticProxy proxyImage = new StaticProxy("image_1");
        proxyImage.displayImage();
    }

    @Test
    public void testDynamicProxy(){
        DynamicProxy dynamicProxy = new DynamicProxy();
        com.designpattern.proxy.dynamicproxy.Image image = (com.designpattern.proxy.dynamicproxy.Image) dynamicProxy.getInstance("image_2");
        image.displayImage();
    }

    @Test
    public void testCglibProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        com.designpattern.proxy.cglb.RealImage image = (com.designpattern.proxy.cglb.RealImage) cglibProxy.getInstance("image_3");
        image.displayImage();
    }

}
