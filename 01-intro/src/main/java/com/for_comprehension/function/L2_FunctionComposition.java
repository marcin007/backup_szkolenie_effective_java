package com.for_comprehension.function;

import java.util.List;
import java.util.function.Function;

class L2_FunctionComposition {
    public static void main(String[] args) {
        Function<String, Integer> f1 = s -> Integer.valueOf(s);
        Function<String, Integer> f2 = f1.andThen(i -> i + 1);
    }
}
