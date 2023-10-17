package com.for_comprehension.function.l2_generics;

import java.util.ArrayList;
import java.util.List;

class L2_GenericsExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = new ArrayList<>();
        List<String> strings = List.of("str");
        List<?> something = null;

//        something.add(1); does not compile

        List<Integer>[] numsArray = (List<Integer>[]) new List[4];
        Integer[] intArray = new Integer[4];

        Number a = 1;
        numbers = ints;
//        numbers.add(1); does not compile
//        numbers.addAll(numbers); does not compile

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
