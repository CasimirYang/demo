package com.algorithm;

/**
 * 递归与循环
 *
 * 递归一般好理解,循环效率高
 *
 */
public class Recursive {

    public static void main(String[] args) {
        System.out.println(JumpFloorI(4));
    }

    //这里有n个台阶，每次能爬1或2节，请问有多少种爬法？
    public static int re(int n){
        if(n <= 2) return n;
        int x = re(n-1) + re(n-2);  //斐波那契数列
        return x;
    }


    //把以上递归转为循环 更快
    public static int iter(int n){
        if (n <= 2){
            return n;
        }
        int first = 1, second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
     跳1级，剩下n-1级，则剩下跳法是f(n-1)
     跳2级，剩下n-2级，则剩下跳法是f(n-2)
     所以f(n)=f(n-1)+f(n-2)+...+f(1)+f(0)
     因为f(n-1)=f(n-2)+f(n-3)+...+f(1)+f(0)
     所以f(n)=2*f(n-1)
     */
    public static int JumpFloor(int n){
        if(n == 1){
            return 1;
        }
        return 2*JumpFloor(n-1);
    }

    //转为循环
    public static int JumpFloorI(int n){
        if(n == 1){
            return 1;
        }
        int target = 1;
        for (int i = 1; i < n; i++) {
            target = 2*target;
        }
        return target;
    }
}
