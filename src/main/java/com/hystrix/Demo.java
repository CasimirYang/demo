package com.hystrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Lenovo on 2017/9/12.
 */
public class Demo {

    public static void main(String[] args) {
        long a = 1;
        System.out.println(new BigDecimal(a).divide(new BigDecimal(100),2, RoundingMode.HALF_UP));
    }
}
