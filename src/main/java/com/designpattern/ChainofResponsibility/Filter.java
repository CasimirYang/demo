package com.designpattern.ChainOfResponsibility;

/**
 * 意图：为请求创建了一个接收者对象的链,让多个对象都有可能接收请求.

 关键代码：Handler 里面聚合它自己，在 HanleRequest 里按需判断是否需要向下传递。

 应用实例： 1.JS 中的事件冒泡。 3、JAVA WEB 中servlet 的 Filter。

 */
public  abstract class Filter {

    //责任链中的下一个元素
    protected Filter nextFilter;

    public void setNextFilter(Filter filter) {
        this.nextFilter = filter;
    }

    public void doChain(String message){
        //这一链的处理
        doFilter(message);
        //下一链
        if(nextFilter != null){
            nextFilter.doChain(message);
        }
    }

   abstract void doFilter(String message);
}
