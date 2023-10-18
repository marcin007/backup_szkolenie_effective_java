package com.for_comprehension.function.l11_completablefuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class L11_CompletableFutureExecution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(4);

        Integer join = CompletableFuture.supplyAsync(() -> 1, e)
          .thenApplyAsync(i -> process(i), e)
          .thenApplyAsync(i -> process(i), e)
          .thenApplyAsync(i -> process(i), e)
          .thenApplyAsync(i -> process(i), e)
          .thenApplyAsync(i -> process(i), e)
          .thenApplyAsync(i -> process(i), e)
          .join();
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
