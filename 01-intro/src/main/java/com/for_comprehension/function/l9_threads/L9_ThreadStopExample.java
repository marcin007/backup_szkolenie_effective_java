package com.for_comprehension.function.l9_threads;

import java.util.concurrent.atomic.AtomicBoolean;

class L9_ThreadStopExample {
    private static final ConcurrentHolder HOLDER = new ConcurrentHolder();

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Processing i: " + i + " on thread: " + Thread.currentThread().getName());
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Processing i: " + i + " on thread: " + Thread.currentThread().getName());
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Processing i: " + i + " on thread: " + Thread.currentThread().getName());
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10_000);

        t3.stop();

        Thread.sleep(5_000);

        t2.stop();

        Thread.sleep(5_000);

        t1.stop();

        /*

        Exception in thread "Thread-0" java.lang.IllegalStateException: holder is broken :o
	at com.for_comprehension.function.l9_threads.L9_ThreadStopExample$ConcurrentHolder.processValue(L9_ThreadStopExample.java:67)
	at com.for_comprehension.function.l9_threads.L9_ThreadStopExample.lambda$main$0(L9_ThreadStopExample.java:14)
	at java.base/java.lang.Thread.run(Thread.java:833)
Processing i: 7 on thread: Thread-1
Exception in thread "Thread-1" java.lang.IllegalStateException: holder is broken :o
	at com.for_comprehension.function.l9_threads.L9_ThreadStopExample$ConcurrentHolder.processValue(L9_ThreadStopExample.java:67)
	at com.for_comprehension.function.l9_threads.L9_ThreadStopExample.lambda$main$1(L9_ThreadStopExample.java:26)
	at java.base/java.lang.Thread.run(Thread.java:833)

         */
    }

    private static class ConcurrentHolder {
        private final AtomicBoolean isDirty = new AtomicBoolean(false);

        public synchronized void processValue(int i) {
            if (isDirty.getAndSet(true)) {
                throw new IllegalStateException("holder is broken :o");
            }

            System.out.println("processing i: " + i + " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            isDirty.set(false);
        }
    }
}
