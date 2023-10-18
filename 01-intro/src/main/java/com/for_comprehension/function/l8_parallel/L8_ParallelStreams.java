package com.for_comprehension.function.l8_parallel;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Stream;

class L8_ParallelStreams {

    public static void main(String[] args) {
        var result = timed(() -> Stream.of(1, 2, 3, 4)
          .parallel()
          .map(i -> process(i))
          .toList());

        System.out.println(result);
    }

    private static <T> T timed(Supplier<T> supplier) {
        var before = Instant.now();
        T result = supplier.get();
        var after = Instant.now();
        System.out.println(STR."Execution time: \{Duration.between(before, after).toMillis()} ms");
        return result;
    }

    public static <T> T process(T input) {
        try {
            System.out.println(STR."Processing \{input} on thread: \{Thread.currentThread().getName()}");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return input;
    }
}
