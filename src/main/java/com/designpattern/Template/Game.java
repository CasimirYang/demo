package com.designpattern.Template;

/**
 * 抽象类定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 行为由父类控制，子类实现。
 *
 * 实例:Spirng 中对 Hibernate 的支持，将一些已经定好的方法封装起来，
 * 比如开启事务、获取 Session、关闭 Session 等，不需要重复写那些已经规范好的代码，直接丢一个实体就可以保存。
 **/
public abstract class Game{

    abstract void init();
    abstract void startPlay();
    abstract void destroy();

    //为防止恶意操作，一般模板方法都加上 final 关键词。
    public final void play(){
        init();
        startPlay();
        destroy();
    }
}