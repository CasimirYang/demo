package com.webservice.cxf;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by yjh on 16/9/28.
 */
@WebService(endpointInterface= "com.webservice.cxf.MyService",serviceName="" +
        "bilibili",portName = "ppii",targetNamespace = "lili")
public class MyServiceImpl implements MyService {

    @Override
    @WebResult(name="addResult")
    public int add(@WebParam(name="firstA")int a , @WebParam(name="SecondB")int b) {
        System.out.print(a+"+"+b+"="+(a+b));
        if(a !=5 ){
            throw new NullPointerException("aa");
        }
        return a+b;
    }

    @Override
    public int minus(int a,int b) {
        return a-b;
    }

    }
