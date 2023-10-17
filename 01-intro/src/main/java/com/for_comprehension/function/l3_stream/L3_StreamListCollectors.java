package com.for_comprehension.function.l3_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class L3_StreamListCollectors {
    public static void main(String[] args) {
        List<String> r1 = getUsers().collect(Collectors.toList());
        Set<String> r2 = getUsers().collect(Collectors.toSet());
        ArrayList<String> r3 = getUsers().collect(Collectors.toCollection(() -> new ArrayList<>()));
        List<String> r4 = getUsers().collect(Collectors.toUnmodifiableList());

        try {
            List<String> r5 = Stream.of("a", "b", null).collect(Collectors.toUnmodifiableList());
        } catch (Exception e) {
            System.out.println("Nulls not allowed. Have you read the docs? :)");
        }

        List<String> r6 = Stream.of("a", "b", null).toList();
        try {
            r6.clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Unmodifiable list! Have you read the docs? :)");
        }

        Map<String, Integer> r7 = getUsers().collect(Collectors.toMap(s -> s, s -> s.length()));

        String r8 = getUsers().collect(Collectors.joining(",", "prefix:", ":suffix"));
    }

    static List<String> getUserItems(String username) {
        return List.of("Box", "Phone");
    }

    static Stream<String> getUsers() {
        return Stream.of("John", "Adam", "Ewa");
    }
}
