package com.for_comprehension.function.E06;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

class ParallelCollectionProcessingCompletableFuture {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4);

        try (ExecutorService e = new ThreadPoolExecutor(0, 1000,
          1L, TimeUnit.MINUTES,
          new SynchronousQueue<>())) {

            timed(() -> input.stream()
              .map(i -> CompletableFuture.supplyAsync(() -> process(i), e))
              .collect(collectingAndThen(toList(), fs -> combined(fs)))
              .thenAccept(System.out::println)
              .join());

        }
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

    static <T> CompletableFuture<List<T>> combined(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> r = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        futures.forEach(future -> future.whenComplete((__, throwable) -> {
            if (throwable != null) {
                r.completeExceptionally(throwable);
            }
        }));
        return r
          .thenApply(__ -> futures.stream()
            .map(CompletableFuture::join)
            .toList());
    }
}
