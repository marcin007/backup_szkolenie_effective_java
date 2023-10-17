package com.for_comprehension.function.E05;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CustomJoiningCollectorForLazyDevelopers {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString())); // 123
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString(","))); // 1,2,3
        System.out.println(Stream.of(1, 2, 3).collect(joiningToString(",", "[", "]"))); // [1,2,3]
        System.out.println(Stream.of().collect(joiningToString(",", "[", "]"))); // []
        System.out.println(Stream.of(1).collect(joiningToString(",", "[", "]"))); // [1]
    }

    private static <T> Collector<T, ?, String> joiningToString() {
        return joiningToString("");
    }

    private static <T> Collector<T, ?, String> joiningToString(String delimiter) {
        return joiningToString(delimiter, "", "");
    }

    private static <T> Collector<T, ?, String> joiningToString(String delimiter, String prefix, String suffix) {
        return new CustomToStringCollector<>(delimiter, prefix, suffix);
    }

    record CustomToStringCollector<T>(String delimiter, String prefix, String suffix)
      implements Collector<T, List<String>, String> {
        @Override
        public Supplier<List<String>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<String>, T> accumulator() {
            return (strings, t) -> strings.add(t.toString());
        }

        @Override
        public BinaryOperator<List<String>> combiner() {
            return (strings, strings2) -> {
                strings.addAll(strings2);
                return strings;
            };
        }

        @Override
        public Function<List<String>, String> finisher() {
            return list -> {
                var stringJoiner = new StringJoiner(delimiter, prefix, suffix);
                list.forEach(stringJoiner::add);
                return stringJoiner.toString();
            };
        }

        public Function<List<String>, String> finisher2() {
            return list -> list.stream().collect(Collectors.joining(delimiter, prefix, suffix));
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }
    }
}
