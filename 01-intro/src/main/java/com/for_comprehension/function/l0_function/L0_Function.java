package com.for_comprehension.function.l0_function;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static java.util.function.Predicate.not;

class L0_Function {

    /*

    (String a, Integer b) -> {
        ...
        return a + b;
    }

    (a, b) -> {
        ...
        return a + b;
    }

    (a, b) -> a + b;

    a -> a + 1;

    () -> 42;

    (@Nullable var a, var b) -> a + b;
     */
    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello world!")).start();

        Function<String, Integer> f1 = s -> Integer.valueOf(s);
        Predicate<Integer> f2 = i -> i % 2 == 0; // Function<Integer, Boolean>
        Consumer<Integer> f3 = i -> System.out.println(i); // Function<Integer, Void>
        Supplier<Integer> f4 = () -> 42; // Function<Void, Integer>

        UnaryOperator<Integer> f5 = i -> i + 1; // Function<T, T>
        Callable<Integer> f6 = () -> 42; // Function<Void, Integer> throws Exception
        Runnable f7 = () -> { System.out.println("Hello!"); }; // Function<Void, Void>

        BiFunction<Integer, Integer, Integer> f8 = (i1, i2) -> i1 + i2;
        BinaryOperator<Integer> f9 = (i1, i2) -> i1 + i2; // BiFunction<Integer, Integer, Integer>

        Function<String, Integer> f10 = f1.andThen(i -> i + 1);

        Optional.of(4).filter(not(L0_Function::isEven));
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
}
