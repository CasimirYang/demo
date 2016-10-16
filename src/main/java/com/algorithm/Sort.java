package com.algorithm;

import org.junit.Test;

import javax.xml.soap.SOAPPart;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yjh on 16/10/8.
 */
public class Sort {

    public static String reverseWords(String s) {
        String[] temp =  s.trim().split("\\s+");
        System.out.println(temp.length);
        String target="";
        for(int i = temp.length-1;i>=0;i--){
            target+=temp[i]+" ";
        }
        return target.trim();
    }

    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String target="";
        for(int i =0; i<s.length(); i++){
            int left=i,right=i;
                while( left>=0 && right<s.length()){
                while((right+1)<s.length() && s.charAt(left) == s.charAt(right+1)){
                    right++;
                }
                if(s.charAt(left)==s.charAt(right)) {
                    left--;
                    right++;
                }
            }
            int length = right-(left+1);
            if(length > maxLength){
                maxLength = length;
                target = s.substring(left+1,right);
            }
        }
        return target;
}

    public static void main(String[] args) {
        int[] array = new int[]{9,5,3,4,8,2,1,7};
       // bubbleSort(array);
      //  System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{4,5,3,6,7};
       // quickSort(array2,0,array2.length-1);

        System.out.println(-3<<2);
        System.out.println(longestPalindrome("ccd"));
    }

    static void bubbleSort(int[] array){
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < (array.length-i); j++) {
               if( array[j] > array[j+1]){
                   temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
               }
            }
        }
    }

    //通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
    // 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行
    static void quickSort(int[] array,int low,int high){

        //get pivot
        int middle = (low+high) >> 2;
        int pivot = array[middle];

        // make left < pivot and right > pivot
        int left = low, right = high;
        while (left <= right){
            while (array[left] < pivot){
                left++;
            }
            while (array[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        // recursively sort two sub parts
        if(right > low ){
            quickSort(array,low,right);
        }
        if (left < high){
            quickSort(array,left,high);
        }
    }



}

