package com.demo;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjh on 16/10/16.
 */
public class GuavaTest implements Comparable<GuavaTest>{
    private String name;
    private Integer age;
    private ArrayList<HashCodeTest> list;

    @Override
    public String toString() {
        return "GuavaTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuavaTest)) return false;
        GuavaTest guavaTest = (GuavaTest) o;
        return Objects.equal(name, guavaTest.name) &&
                Objects.equal(age, guavaTest.age) &&
                Objects.equal(list, guavaTest.list);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, list);
    }

    @Override
    public int compareTo(GuavaTest that) {
        return ComparisonChain.start()
                .compare(this.name, that.name)
                .compare(this.age, that.age)
                .result();

    }

    public static void main(String[] args) throws FileNotFoundException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    }
}
