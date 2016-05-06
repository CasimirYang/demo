package com.generic;

import java.util.ArrayList;
import java.util.List;

/**
 *    范型有子类型化的规则，比如List<String>是List<?>和原生态List的子类，但不是List<Object>的子类
 */
public class Subtyping {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
      //  fun(list,new Integer(1));   //error, List<String> 不是List<Object>子类,他们没有任何关系
        fun2(list,new Integer(1));  //没有类型检查,List<String> 是List 子类,所以可以
        fun3(list,new Integer(1));  //List<String>的父类是List<?>
    }
    static List fun(List<Object> list, Object obj){
        list.add(obj);
        return list;
    }
    static List fun2(List list, Object obj){
        list.add(obj);
        return list;
    }
    static List fun3(List<?> list, Object obj){
     //   list.add(obj);  //error, List<?> 类型是未知的,不可以直接操作子元素
        return list;
    }
}


