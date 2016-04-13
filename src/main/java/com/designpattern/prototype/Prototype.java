package com.designpattern.prototype;


import java.math.BigDecimal;

public class Prototype implements Cloneable {

    String name;
    BigDecimal number;
    int count;


    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    public Prototype() {
    }

    public Prototype(String name, BigDecimal number, int count) {
        this.name = name;
        this.number = number;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

