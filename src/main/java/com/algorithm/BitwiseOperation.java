package com.algorithm;

/**
 *一个整数减去1 再与它原来整数做位与运算相当于原来整数最后一个1变成0;很多问题都可以通过这个解决
 */
public class BitwiseOperation {

    public static void main(String[] args) {
        //System.out.println(getOne(-7));
        //System.out.println(sameBit(10,13));
        //System.out.println(findSingle(new int[]{1,2,3,3,2,1,5,7,8,7,8}));

    }

    /**
     * 问题 : 一个数的二进制中有几个1
     */

    //方法一: 移动目标数取 与; 负数不好处理
    public static  int getOne(int i){
        int target = 0;
        //正数处理
        if(i>0){
            while ( i>0 ){
                if((i & 1) == 1){
                    target++;
                }
                i = i >> 1;
            }
        }
        //负数处理
        else if( i<0 ){

        }

        return target;
    }


     //方法二 移动1
     //循环次数等于二进制的位数 但可以处理负数
    public static  int getOne2(int i){
        int target = 0;
        int j = 1;
        while ( j > 0 ){
            if((i & j) > 0){
                target++;
            }
            j = j << 1;
        }
        return target;
    }

    /**
     * 问题: 判断一个整数是不是 2 的整数次方
     *
     * tips: 2 的整数次方的二进制只有一个1
     */
    public static boolean dev2(int i){
        i = (i-1) & i;
       return i== 0;
    }

    /**
     * 问题: 计算两个整数的二进制有几位不同
     */
    public static int sameBit(int i, int j){
        //异或
        int temp  = i ^ j;

        //计算 temp 二进制中 1 个数
        int target = 0;
        int z = 1;
        while (z > 0){
            if((temp & z) > 0){
                target++;
            }
            z = z << 1;
        }
        return target;
     }

    /**
     * 问题: int 数组, 其中只有一个元素出现了一个,其它都出现了两次,找到那个唯一的
     *
     * 或者用HashSet 的 add; 如果已经存在会返回false
     */
    public static int findSingle(int[] array){
        int i = 0;
        for (int item : array) {
            i = i ^ item ;   //两次异或同一个 还原了
        }
        return i;
    }
}
