package com.designpattern.decorator;

/**
 * 增加一个修饰类包裹原来的类，包裹的方式一般是通过在将原来的对象作为修饰类的构造函数的参数。
 * 来动态地给一个对象添加一些额外的职责或者行为。
 *
 */
public abstract class Decorator implements IConponent {

    protected IConponent conponent;

}
