package com.designpattern.builder;


import java.math.BigDecimal;

public class Hero{

    String name;
    BigDecimal atk;

    public Hero(Builder builder){
        this.name= builder.name;
        this.atk = builder.atk;
    }

    @Override
    public String toString() {
       return "这位大虾叫 "+name +" 战斗力为"+atk;
    }

    public static class Builder{

        private String name;
        private BigDecimal atk;

        public Builder setName(String name){
            this.name= name;
            return this;
        }
        public Builder setATK(BigDecimal atk){
            this.atk= atk;
            return this;
        }

        public Hero build(){
            return new Hero(this);
        }
    }
}
