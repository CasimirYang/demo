package com.designpattern.prototype;


import java.math.BigDecimal;

/**
 *
 * 创建新对象成本较大（如初始化需要占用较长的时间，占用太多的CPU资源或网络资源），
 * 新的对象可以通过原型模式对已有对象进行复制来获得，如果是相似对象，则可以对其成员变量稍作修改。
 *
 *
 */
public class Client {

    public static void main(String args[]){
        Prototype prototype = new Prototype("origin name",new BigDecimal(1),4);
        System.out.println(prototype);
        try {
            Prototype prototype_clone = prototype.clone();
            prototype_clone.setName("cnange name");
            System.out.println(prototype_clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
