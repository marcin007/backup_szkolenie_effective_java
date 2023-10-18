package com.for_comprehension.function.l10_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class L10_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var e = Executors.newFixedThreadPool(4)) {
            Future<Integer> future = e.submit(() -> {
                System.out.println("Hello!");
                Thread.sleep(1000);
                return 42;
            });

            Integer result = future.get();
            System.out.println(result);
        }
    }
}
