package com.for_comprehension.function.E05;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
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
      implements Collector<T, StringBuilder, String> {

        @Override
        public Supplier<StringBuilder> supplier() {
            return StringBuilder::new;
        }

        @Override
        public BiConsumer<StringBuilder, T> accumulator() {
            return (sb, t) -> {
                if (!sb.isEmpty()) {
                    sb.append(delimiter);
                }
                sb.append(t);
            };
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return StringBuilder::append;
        }

        @Override
        public Function<StringBuilder, String> finisher() {
            return sb -> prefix + sb.toString() + suffix;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }
    }
}
