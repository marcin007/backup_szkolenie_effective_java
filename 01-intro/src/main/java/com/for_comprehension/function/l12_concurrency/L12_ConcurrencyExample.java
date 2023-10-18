package com.for_comprehension.function.l12_concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class L12_ConcurrencyExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong();
        ExecutorService e = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 10; i++) {
            e.submit(() -> {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                for (int i1 = 0; i1 < 1000000; i1++) {
                    counter.incrementAndGet();
                }
            });
        }

        e.shutdown();
        e.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(counter.get());
    }
}
