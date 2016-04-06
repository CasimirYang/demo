package com.designpattern.observer;

/**
 * 观察者模式：多个观察者去监听主题，当主题发生变化的时候，主题会通知所有的观察者。
 *
 *
 * Java 提供了 Observer接口（观察者接口） 和 Observable 类（被观察者类 / 主题类）。
 * 只需用他们创建具体的被观察者类和观察者。
 *
 * setChanged 是必须的，在调用notifyObservers 后改状态会被清除
 */
public class Test {

    public static void main(String args[]){
        Girl girl = new Girl();
        girl.addObserver(new Boy01());
        girl.addObserver(new Boy02());
        girl.postMoments("MM 发了一条朋友圈");
        girl.notifyObservers();
    }
}
