package com.for_comprehension.function.l3_stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class L3_CreateStream {
    public static void main(String[] args) {
        Stream<String> s1 = getUsers().stream();

        Stream<Integer> s2 = Stream.of(1, 2, 3);

        Stream<Integer> s3 = Stream.concat(Stream.of(1), Stream.of(2));

        Stream<Integer> s4 = Stream.generate(() -> 42);

        Stream<Integer> s5 = Stream.iterate(0, i -> i + 1);

        Stream<Integer> s6 = Stream.<Integer>builder()
          .add(1)
          .add(2)
          .add(3)
          .build();

        Stream<String> s7 = Stream.ofNullable("");

        IntStream s8 = IntStream.range(0, 100);

        IntStream s9 = IntStream.rangeClosed(0, 100);
    }

    static List<String> getUsers() {
        return List.of("John", "Adam", "Ewa");
    }
}
