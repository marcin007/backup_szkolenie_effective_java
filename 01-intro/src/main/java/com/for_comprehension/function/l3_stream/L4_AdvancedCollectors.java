package com.for_comprehension.function.l3_stream;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.toList;

class L4_AdvancedCollectors {
    public static void main(String[] args) {
        List<String> r1 = getUsers()
          .collect(collectingAndThen(toList(),
            Collections::unmodifiableList));

        Double r2 = Stream.of(1, 2, 3)
          .collect(teeing(
            summingDouble(i -> i),
            counting(),
            (sum, count) -> sum / count));

        // https://4comprehension.com/the-ultimate-guide-to-the-java-stream-api-groupingby-collector/
        LinkedHashMap<Integer, String> r3 = getUsers()
          .collect(groupingBy(String::length, LinkedHashMap::new, joining(",")));

        Map<String, Integer> r4 = getPrices()
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::min));

        System.out.println(r4);
    }

    static Stream<String> getUsers() {
        return Stream.of("John", "Adam", "Ewa");
    }

    static Stream<Map.Entry<String, Integer>> getPrices() {
        return Stream.of(
          Map.entry("milk", 5),
          Map.entry("bread", 2),
          Map.entry("gasoline", 8),
          Map.entry("milk", 7)
        );
    }
}
