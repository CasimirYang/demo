package com.designpattern.observer;

/**
 原理： 被观察者（主题）维护了一个观察者类型的链表，每当主题变化的时候，就会循环调用各个观察者的对应方法（这就是通知）。
 四元素：
        抽象的被观察者（维和观察者表并调用观察者暴露的更新方法）, 　 //也可以只是普通类 逻辑上抽象， 比如Java提供的Observable　虽然只是普通类，但相当于被观察者接口
        具体被观察者;
        抽象的观察者（定义更新方法）
        具体观察者  (定义具体的更新方法)
 作用：
        观察者模式解除了主题和具体观察者的耦合，让耦合的双方上升到抽象级别，而不是依赖具体。从而使得各自的变化都不会影响另一边的变化。
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
