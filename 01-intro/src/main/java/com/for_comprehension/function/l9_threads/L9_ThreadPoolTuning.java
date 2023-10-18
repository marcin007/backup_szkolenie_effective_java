package com.for_comprehension.function.l9_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class L9_ThreadPoolTuning {

    public static final int N_THREADS = 4;
    public static final int MAX_THREADS = 8;
    public static final int QUEUE_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        // JDK21
        try (var e = (ExecutorService) new ThreadPoolExecutor(N_THREADS, MAX_THREADS,
          1L, TimeUnit.MINUTES,
          new LinkedBlockingQueue<>(QUEUE_SIZE),
          Thread.ofPlatform()
            .name("mail-sender-", 0)
            .factory(), new ThreadPoolExecutor.DiscardOldestPolicy())) {
            for (int i = 0; i < MAX_THREADS + QUEUE_SIZE + 1; i++) {
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
