package com.for_comprehension.function.l4_unmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class L4_UnmodifiableActuallyModifiable {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        List<Integer> unmodifiableInts = Collections.unmodifiableList(ints);

        ints.add(4);
        System.out.println(unmodifiableInts);
    }
}
