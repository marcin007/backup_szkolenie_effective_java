package com.for_comprehension.function.l9_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class L9_ThreadPoolTuningSynchronousQueue {

    public static final int N_THREADS = 4;
    public static final int MAX_THREADS = 8;

    public static void main(String[] args) throws InterruptedException {
        // JDK21
        try (var e = (ExecutorService) new ThreadPoolExecutor(N_THREADS, MAX_THREADS,
          1L, TimeUnit.MINUTES,
          new SynchronousQueue<>(), //special "zero-element" queue
          Thread.ofPlatform()
            .name("mail-sender-", 0)
            .factory(), new ThreadPoolExecutor.CallerRunsPolicy())) {
            for (int i = 0; i < MAX_THREADS; i++) {
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
}
