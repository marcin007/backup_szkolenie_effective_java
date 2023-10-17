package com.for_comprehension.function.E05;

import java.util.stream.Collector;
import java.util.stream.Stream;

class CustomJoiningCollector {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
          .collect(joiningToString());
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
