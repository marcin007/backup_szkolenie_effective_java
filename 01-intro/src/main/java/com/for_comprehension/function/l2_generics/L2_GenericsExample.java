package com.for_comprehension.function.l2_generics;

import java.util.ArrayList;
import java.util.List;

class L2_GenericsExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = new ArrayList<>();
        List<String> strings = List.of("str");
        List<?> something = List.of(1);

        Number a = 1;
        numbers = ints;
        // TODO wtorek
//        numbers.add(a);

//        process("");
        process(1);
//        process(new Object());
//        process(new Thread());
//        process(strings);
    }

    public static <T extends Number> T process(T input) {
        return input;
    }
}
