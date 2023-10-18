package com.for_comprehension.function.l11_completablefuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class L11_CompletableFutureAllOfAnyOf {

    // thenCompose -> flatMap
    // thenApply -> map
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(4);
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> process(1), e);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> process(2), e);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf1, cf2);
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(cf1, cf2);

        CompletableFuture<Integer> cf3 = cf1.applyToEither(cf2, i -> i);
        CompletableFuture<Integer> cf4 = cf1.thenCombine(cf2, Integer::sum);

        CompletableFuture<String> cf5 = cf1.thenCompose(id -> getUserByIdAsync(id));

        CompletableFuture<Integer> cf6 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException();
            }
            return 42;
        }, e);

        cf6
          .exceptionally(ex -> switch (ex) {
              case IOException ioException -> -1;
              case RuntimeException runtimeException -> -2;
              default -> 42;
          })
          .thenAccept(System.out::println)
          .join();
    }

    private static CompletableFuture<String> getUserByIdAsync(int id) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return STR."John \{id}";
            }, executorService);
        }
    }

    private static <T> T process(T input) {
        try {
            System.out.println(STR."processing \{input} on \{Thread.currentThread().getName()}");
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
        }

        return input;
    }
}
