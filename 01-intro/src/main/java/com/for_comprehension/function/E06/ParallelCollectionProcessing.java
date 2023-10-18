package com.for_comprehension.function.E06;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

class ParallelCollectionProcessing {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4);

        // TODO process in parallel
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
