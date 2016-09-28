package com.webservice.base;

import javax.xml.ws.Endpoint;

/**
 * Created by yjh on 16/9/28.
 */
public class ClientTest {
    public static  void main(String[] args) throws InterruptedException {
        String address="http://localhost:6556/ns";
        Endpoint.publish(address, new MyServiceImpl());
    }
}
