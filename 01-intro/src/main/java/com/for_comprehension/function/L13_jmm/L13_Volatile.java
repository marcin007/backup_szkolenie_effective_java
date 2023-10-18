package com.for_comprehension.function.L13_jmm;

import java.util.concurrent.atomic.AtomicLong;

class L13_Volatile {

    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(flag);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            flag = true;
        }).start();

    }
}
