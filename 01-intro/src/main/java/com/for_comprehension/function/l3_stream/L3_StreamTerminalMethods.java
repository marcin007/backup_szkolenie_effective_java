package com.for_comprehension.function.l3_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class L3_StreamTerminalMethods {
    public static void main(String[] args) {
        List<String> r1 = getUsers().collect(Collectors.toList());
        Set<String> r2 = getUsers().collect(Collectors.toSet());
        ArrayList<String> r3 = getUsers().collect(Collectors.toCollection(() -> new ArrayList<>()));
        List<String> r4 = getUsers().collect(Collectors.toUnmodifiableList());


    }

    static List<String> getUserItems(String username) {
        return List.of("Box", "Phone");
    }

    static Stream<String> getUsers() {
        return Stream.of("John", "Adam", "Ewa");
    }
}
