package com.for_comprehension.function.l0_function;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class L1_LazyInitSupplier {

    public static void main(String[] args) {
        use(() -> calculate());

        /*
        int calculate = calculate();
        use(calculate);
        */
    }

    public static void use(int a) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            System.out.println(a);
        }
    }

    public static void use(Supplier<Integer> a) {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            System.out.println(a.get());
        }
    }

    public static int calculate() {
        System.out.println("calculating...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        return 42;
    }
}
