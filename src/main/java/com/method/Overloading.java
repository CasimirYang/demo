package com.method;

import java.util.*;

/**
 * 对于重载方法的选择是静态的，调用哪个重载方法是在编译期决定的
    对于覆盖方法的选择是动态的，在运行时才选择被覆盖的方法
 */
public class Overloading {

    public static void fun(Set<?> set) {

    }

    public static void fun(List<?> set) {

    }

    public static void fun(Collection<?> set) {

    }

    public static void main(String[] args) {
        Collection<?>[] collection = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> cc : collection) {
            fun(cc);  //静态选择， 都是调用fun(Collection<?> set)
        }
    }

    void chaosOfOverloading(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);  //set 没有重载这个方法，所以如期望值工作
            list.remove(i); //int 有自动装箱，可惜List重载了这个方法，remove(int index) && remove(Object o)；静态选择了前者
            // list.remove((Integer)i);   这样才是期望删除的值
        }
    }
}





