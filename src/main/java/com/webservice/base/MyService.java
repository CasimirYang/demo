package com.webservice.base;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by yjh on 16/9/28.
 */
    @WebService
    public interface MyService {
        @WebResult(name="addResult")
        //对返回值和参数进行名字定义，否则默认为arg0，arg1...
        public int add(@WebParam(name="firstA")int a , @WebParam(name="SecondB")int b);
        //与上面方法进行对比
        public int minus(int a,int b);
}
