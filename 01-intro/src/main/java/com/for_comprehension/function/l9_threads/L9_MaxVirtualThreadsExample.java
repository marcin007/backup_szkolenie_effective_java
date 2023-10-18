package com.for_comprehension.function.l9_threads;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class L9_MaxVirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newVirtualThreadPerTaskExecutor();

        // 15mln threads: Execution time: 169248 ms :)
        List<Integer> result = timed(() -> IntStream.range(0, 1_000)
          .boxed()
          .map(i -> CompletableFuture.supplyAsync(() -> process(i), e))
          .collect(Collectors.collectingAndThen(Collectors.toList(), l -> combined(l)))
          .join());
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
