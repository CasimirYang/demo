package com.concurrent.raw;

import java.util.*;


public class CombinationList<T> extends ArrayList<T> {

    public final List<T> list;
    private CombinationList(List<T> list) {
        this.list=list;
    }
    public List<T> getList() { return list; }
    /**
     * unsafe
     * putIfAbsent虽然使用了synchronized,但同步的锁是CombinationList,list 还是可以同步进行修改的;
     * 需要 synchronized（list）才能同步(依赖了底层list的同步策略)
     *
     */
    public synchronized boolean putIfAbsent(T x){
        boolean contain = list.contains(x);
       if(contain){
            list.add(x);
       }
       return !contain;
    }
}
