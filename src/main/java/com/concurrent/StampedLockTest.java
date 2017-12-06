package com.concurrent;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    void stampedLock(){

    }

    public static void main(String[] args) {
        Point point = new Point();
        point.getSum();
    }

    static class Point{
        private double x;
        private double y;
        private final StampedLock sl = new StampedLock();
        /**
         * 获取乐观锁后发现已经被修改，直接获取read Lock
         */
        public double getSum(){
            long stamp = sl.tryOptimisticRead();
            System.out.println(stamp);
            double sum = x+y;
            if(!sl.validate(stamp)){
                stamp = sl.readLock();
                try{
                    sum = x+y;
                }finally {
                    sl.unlockRead(stamp);
                }
            }
            return sum;
        }
        /**
         * 先获取读锁判断状态再通过锁升级的方式获取写锁，可以降低一定的获取写锁的频率
         */
        public void setPointIfAtOrigin(double newX,double newY){
            long stamp = sl.readLock();
            try{
                while (x == 0.0 && y == 0.0) {
                    long ws = sl.tryConvertToWriteLock(stamp); // upgrade
                    if(ws!=0){
                        x = newX;
                        y = newY;
                        break;
                    }else {
                        sl.unlockRead(stamp);
                        sl.writeLock();
                    }
                }
            }finally {
                sl.unlock(stamp);
            }
        }
    }


}
