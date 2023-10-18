package com.for_comprehension.function.l9_threads;

class L9_MaxThreadsExample {

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            Thread.sleep(2);
            long finalI = i;
            new Thread(() -> {
                System.out.println(finalI);
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                }
            }).start();
        }
    }
}
