package com.for_comprehension.function;

import java.util.List;

class L1_DeclarativeVsImperative {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        // imperative
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // declarative
        list.forEach(System.out::println);
    }
}
