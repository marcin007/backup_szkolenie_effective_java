package com.for_comprehension.function.l6_template_method;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

class L6_TemplateMethodModern {

    // JMH - do benchmarków
    public static void main(String[] args) {
        String result = timed(() -> process("foo"));

//        timedNanos(() -> 42);
    }

    static <T> T timed(Supplier<T> supplier) {
        var before = Instant.now();
        T result = supplier.get();
        var after = Instant.now();
        System.out.println(STR."Execution time: \{Duration.between(before, after).toMillis()} ms");
        return result;
    }

    static <T> T timedNanos(Supplier<T> supplier) {
        long before = System.nanoTime();
        T result = supplier.get();
        long after = System.nanoTime();
        System.out.println(STR."Execution time: \{after - before} ns");
        return result;
    }

    static void runWithLogging(Runnable runnable) {
        System.out.println(STR."entering method at: \{Instant.now()}");
        runnable.run();
        System.out.println(STR."exiting method at: \{Instant.now()}");
    }

    private static String process(String input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return input.toUpperCase();
    }
}
