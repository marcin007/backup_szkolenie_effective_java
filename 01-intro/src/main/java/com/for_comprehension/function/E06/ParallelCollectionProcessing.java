package com.for_comprehension.function.E06;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

class ParallelCollectionProcessing {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4);

        try (ExecutorService e = new ThreadPoolExecutor(0, 1000,
          1L, TimeUnit.MINUTES,
          new SynchronousQueue<>())) {
            List<Integer> result = timed(() -> {
                List<Future<Integer>> futures = new ArrayList<>();

                for (Integer i : input) {
                    Future<Integer> r = e.submit(() -> process(i));
                    futures.add(r);
                }

                List<Integer> results = new ArrayList<>();

                for (Future<Integer> future : futures) {
                    try {
                        results.add(future.get());
                    } catch (InterruptedException | ExecutionException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                return results;
            });
            System.out.println(result);
        }
    }

    public static void syncExample(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4);
        List<Integer> result = timed(() -> input.stream().map(i -> process(i)).toList());
        System.out.println(result);
    }

    static <T> T timed(Supplier<T> supplier) {
        var before = Instant.now();
        T result = supplier.get();
        var after = Instant.now();
        System.out.println(STR."Execution time: \{Duration.between(before, after).toMillis()} ms");
        return result;
    }

    private static <T> T process(T input) {
        try {
            System.out.println(STR."processing \{input} on \{Thread.currentThread().getName()}");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return input;
    }
}
