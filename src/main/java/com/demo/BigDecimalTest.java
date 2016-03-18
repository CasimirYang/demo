package com.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 1.小数如果不用字符串的方式new, 那生成的BigDecimal sacle 和 precision 会很大
 * 2. precision 不包括0, 比如字符串构造的 0.1 的precision 和scale 都是1
 *
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal2 = new BigDecimal(0.1);
        BigDecimal bigDecimal3 = new BigDecimal("1.6"); //字符串构建 ; 推荐

        BigDecimal bigDecimal4 = new BigDecimal(1.12554);
        BigDecimal newOne = bigDecimal4.setScale(3, RoundingMode.HALF_EVEN);  //BigDecimal 是immutable, 需要而外一个Obj;  比如: BigDecimal 四则运算返回新BigDecimal


        System.out.println(bigDecimal.scale() + "---" + bigDecimal2.scale() + "---" + bigDecimal3.scale() + "---" + newOne.scale());
        System.out.println(bigDecimal.precision() + "---" + bigDecimal2.precision() + "---" + bigDecimal3.precision() + "---" + newOne.precision());

        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal3);
        System.out.println(newOne);

/*
        0---55---1---3
        1---55---2---4
        1
        0.1000000000000000055511151231257827021181583404541015625
        1.6
        1.126
 */

        BigDecimal b = new BigDecimal("0.1");
        BigDecimal a = new BigDecimal(0.1);
        System.out.println("--" + b.compareTo(a.setScale(1,RoundingMode.DOWN))); //注意这里其实是新的Bigdecimal

        //compareTo 要需要设置scale 比较
    }
}
