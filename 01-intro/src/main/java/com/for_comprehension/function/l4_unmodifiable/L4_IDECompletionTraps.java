package com.for_comprehension.function.l4_unmodifiable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class L4_IDECompletionTraps {
    public static void main(String[] args) {
        List<Integer> result = Stream.of(1, 2, 3, 4, null)
          .collect(Collectors.toUnmodifiableList());

        // IDE suggests replacing .collect(Collectors.toUnmodifiableList()); with toList() which supports nulls
    }
}
