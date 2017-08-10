package com.jvm;

import sun.misc.Contended;

/**
 * 五千万次访问 伪共享 2000ms，共享700ms
 */
public class FalseSharing implements Runnable{

    private static ValueNoPadding[] longs = new ValueNoPadding[10];
    {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new ValueNoPadding();
        }
    }

    private int arrayIndex = 0;
    public FalseSharing(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
            System.gc();
            runTest();
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        long i = 50_000_000L + 1;
        final long start = System.currentTimeMillis();
        while (0 != --i) {
            longs[arrayIndex].value = 0L;
        }
        System.out.println("Thread duration = " + (System.currentTimeMillis() - start));
    }

    public final static class ValuePadding {
        protected long p1, p2, p3, p4, p5, p6, p7;
        protected volatile long value = 0L;
        protected long p9, p10, p11, p12, p13, p14;
        protected long p15;
    }

    public final static class ValueNoPadding {
        //need VM param:
        // -XX:-RestrictContended

        // protected long p1, p2, p3, p4, p5, p6, p7;
        @Contended
        protected volatile long value = 0L;
        // protected long p9, p10, p11, p12, p13, p14, p15;
    }
}
