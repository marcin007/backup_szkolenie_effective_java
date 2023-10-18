package com.for_comprehension.function.l11_completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class L11_CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> process(42), e)
          .thenApply(i -> i + 1)
          .thenApply(i -> i.toString())
          .thenApply(i -> i.toUpperCase() + ":suffix")
          .thenAccept(System.out::println);

        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
        cf1.complete(42);
        cf1.cancel(true);
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
