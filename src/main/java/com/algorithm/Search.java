package com.algorithm;

import java.util.*;

/**
 * 优点:比较次数少，查找速度快；
 * 缺点: 是要求待查表为有序表，且插入删除困难。
 *
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 */
public class Search {
    int i = 1;
    public static void main (String[] args){
        int i = 1000;
        long j = i; //Implicit casting
        StringTokenizer sstr = new StringTokenizer("bb");
                StringBuilder sb = new StringBuilder();
        sb.reverse();
        String str1 = new String("1");
        String str2 = new String("1");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

    }

    public Search() {
    }
    public void Search() {
    }
    //二分查找
    public static int binarySearch(int[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high){
            int middle = (high + low) >> 1;
            if( srcArray[middle] == des){
                return middle;
            }else if(srcArray[middle] > des){
                high = middle-1;
            }else{
                low = middle+1;
            }
        }
        return  -1;
    }
}
