package com.for_comprehension.function.l9_threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class L9_ThreadPoolCached {

    public static void main(String[] args) throws InterruptedException {
        // JDK21
        try (var e = Executors.newCachedThreadPool(Thread.ofPlatform()
          .name("mail-sender-",  0)
          .factory())) {
            for (int i = 0; i < 40; i++) {
                Thread.sleep(1000);
                int finalI = i;
                e.submit(() -> {
                    System.out.println(STR."Processing \{finalI} on \{Thread.currentThread().getName()}");
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException ex) {
                    }
                });
            }
            Thread.sleep(120_000);
        }
    }
}
