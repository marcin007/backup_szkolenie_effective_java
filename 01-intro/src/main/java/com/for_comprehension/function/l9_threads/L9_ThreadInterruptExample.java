package com.for_comprehension.function.l9_threads;

import java.util.concurrent.atomic.AtomicBoolean;

class L9_ThreadInterruptExample {
    private static final ConcurrentHolder HOLDER = new ConcurrentHolder();

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted t1, closing");
                    break;
                }
                try {
                    Thread.sleep(500);
                    System.out.println(STR."Processing i: \{i} on thread: \{Thread.currentThread().getName()}");
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException t1, closing");
                    break;
                }
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted t2, closing");
                    break;
                }
                try {
                    Thread.sleep(500);
                    System.out.println(STR."Processing i: \{i} on thread: \{Thread.currentThread().getName()}");
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException t2, closing");
                    break;
                }
            }
        });

        var t3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted t3, closing");
                    break;
                }
                try {
                    Thread.sleep(500);
                    System.out.println(STR."Processing i: \{i} on thread: \{Thread.currentThread().getName()}");
                    HOLDER.processValue(i);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException t3, closing");
                    break;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10_000);

        t3.interrupt();

        Thread.sleep(5_000);

        t2.interrupt();

        Thread.sleep(5_000);

        t1.interrupt();
    }

    private static class ConcurrentHolder {
        private final AtomicBoolean isDirty = new AtomicBoolean(false);

        public synchronized void processValue(int i) {
            if (isDirty.getAndSet(true)) {
                throw new IllegalStateException("holder is broken :o");
            }

            System.out.println("processing i: " + i + " by " + Thread.currentThread().getName());
            // simulates processing, transparently
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            isDirty.set(false);
        }
    }
}
