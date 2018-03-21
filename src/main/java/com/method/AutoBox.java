package com.method;

public class AutoBox {

    /**
     * 自动装箱使用 XXX.valueOf() -128~127不会new对象，重用对象
     * equals 比较首先需要是同一类型，否则直接false
     * c ==(a+b) 会触发自动拆箱和类型转换（如果需要）
     */
    public static void main(String[] args){
        Integer a =1; //Integer.valueOf(1)
        Integer b =2;
        Integer c =3;
        Integer d =3;
        Integer e =321;
        Integer f = 321;
        Long g =3L; //Long.valueOf(3L)

        System.out.println( c == d); //true         同一个 Integer; if_acmpne
        System.out.println(e == f); //false         不是同一个 Integer;
        System.out.println(g.equals(a+b)); //false  需要是同一个类型,否则false
        System.out.println(c ==(a+b)); //true       XXX.intValue -> iadd -> if_icmpne
        System.out.println(g ==(a+b)); //true       iadd -> i2l -> lcmp
        //System.out.println(g == c);               编译出错，不能直接比较 Integer,Long
    }
}
