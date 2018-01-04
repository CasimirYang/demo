package com.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class DateTest {

    public static void main(String[] args) {
//        BigDecimal payAmount = new BigDecimal("1000");
//        String prices = "3";
//        BigDecimal eachPrin = payAmount.divide(new BigDecimal(prices),2,BigDecimal.ROUND_UP);
//        System.out.println(eachPrin);

        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal b2 = new BigDecimal("11.01");
        b1 = b2;
        System.out.println(b1);

//        Calendar originalDate = Calendar.getInstance();
//        originalDate.add(Calendar.DATE,2);
//        System.out.println(originalDate.getTime());
//        for (int i = 1; i < 20; i++) {
//            Calendar nextDate = (Calendar) originalDate.clone();
//            nextDate.add(Calendar.MONTH, i);
//            System.out.println("The Next month date is: " + nextDate.getTime());

    }
}
