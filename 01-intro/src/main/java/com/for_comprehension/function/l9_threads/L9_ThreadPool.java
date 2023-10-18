package com.for_comprehension.function.l9_threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class L9_ThreadPool {

    public static final int N_THREADS = 4;

    public static void main(String[] args) {
        // JDK21
        try (var e = Executors.newFixedThreadPool(N_THREADS, Thread.ofPlatform()
          .name("mail-sender-",  0)
          .factory())) {
            for (int i = 0; i < N_THREADS; i++) {
                int finalI = i;
                e.submit(() -> {
                    System.out.println(STR."Processing \{finalI} on \{Thread.currentThread().getName()}");
                    try {
                        Thread.sleep(2_000);
                    } catch (InterruptedException ex) {
                    }
                });
            }
        }
    }

    // JDK8
    static ThreadFactory named(String prefix) {
        return new ThreadFactory() {

            private final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, STR."\{prefix}-\{counter.getAndIncrement()}");
            }
        };
    }
}
