package com.for_comprehension.function.l3_stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

class L3_StreamTerminalMethods {
    public static void main(String[] args) {
        Optional<String> r1 = getUsers().findAny();
        Optional<String> r2 = getUsers().findFirst();
        Optional<String> r3 = getUsers().max(comparing(String::length));
        Optional<String> r4 = getUsers().min(comparing(String::length));
        Optional<String> r5 = getUsers().reduce((s1, s2) -> s1 + s2);
        String r6 = getUsers().reduce("", (s1, s2) -> s1 + s2);

        boolean r7 = getUsers().allMatch(s -> !s.isEmpty());
        boolean r8 = getUsers().noneMatch(s -> s.isEmpty());
        boolean r9 = getUsers().anyMatch(s -> s.isEmpty());

        System.out.println(Stream.of().allMatch(i -> true));
        System.out.println(Stream.of().noneMatch(i -> true));
        System.out.println(Stream.of().anyMatch(i -> true));

        long r10 = getUsers().count();
        String[] r11 = getUsers().toArray(String[]::new);
    }

    static List<String> getUserItems(String username) {
        return List.of("Box", "Phone");
    }

    static Stream<String> getUsers() {
        return Stream.of("John", "Adam", "Ewa");
    }
}
