package com.for_comprehension.function.E05;

import java.util.stream.Collector;
import java.util.stream.Stream;

class CustomJoiningCollector {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString())); // 123
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString(","))); // 1,2,3
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString(",", "[", "]"))); // [1,2,3]
        System.out.println(Stream.of().collect(joiningToString(",", "[", "]"))); // []
        System.out.println(Stream.of(1).collect(joiningToString(",", "[", "]"))); // [1]
    }

    // TODO
    private static <T> Collector<T, ?, String> joiningToString() {
        return null;
    }

    // TODO
    private static <T> Collector<T, ?, String> joiningToString(String delimiter) {
        return null;
    }
    // TODO
    private static <T> Collector<T, ?, String> joiningToString(String delimiter, String prefix, String suffix) {
        return null;
    }
}
