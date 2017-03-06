package com.collections;

import java.util.*;

/**
 * TreeMap,TreeSet 依赖实现Comparable 的compareTo接口比较;
 * HashMap,HashSet 依赖hashCode,equals 比较
 */
public class HashCodeTest implements Comparable<HashCodeTest>{
    private String name;
    private Integer age;

    public HashCodeTest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        HashCodeTest demo1 = new HashCodeTest("a",11);
        HashCodeTest demo2 = new HashCodeTest("a",11);
        System.out.println(demo1.hashCode());
        System.out.println(demo2.hashCode());
        TreeMap<HashCodeTest,Integer> map = new TreeMap<>();
        map.put(demo1,1);
        map.put(demo2,2);
        System.out.println(map.keySet()); //TreeMap 依赖实现Comparable 的compareTo接口比较

        HashSet<HashCodeTest> set = new HashSet<>();
        set.add(new HashCodeTest("a",11));
        set.add(new HashCodeTest("a",11));
        System.out.println(set.size()); //HashSet 的key 比较hashcode 和equals

        TreeSet<HashCodeTest> set2 = new TreeSet<>();
        set2.add(new HashCodeTest("a2",11));
        set2.add(new HashCodeTest("a2",11));
        System.out.println(set2.size()); //TreeSet 依赖实现Comparable 的compareTo接口比较
    }
    @Override
    public int hashCode() {
        if (this == null)
            return 0;
        int result = 1;
        result = 31*(31 * result + (this.name == null ? 0 : this.name.hashCode()))+
                (this.age == null ? 0 : this.age.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HashCodeTest) {
            HashCodeTest demo = (HashCodeTest) obj;
            return this.name == demo.name && this.age == demo.age;
        }
        else return false;
    }


    @Override
    public int compareTo(HashCodeTest obj) {
        if (this == obj) {
            return 0;
        }
        HashCodeTest demo = (HashCodeTest) obj;
        if(this.name == demo.name && this.age == demo.age)
            return 0;
        else
            return -1;
    }
}
