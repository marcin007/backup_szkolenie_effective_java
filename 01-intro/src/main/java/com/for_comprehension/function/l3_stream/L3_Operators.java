package com.for_comprehension.function.l3_stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

class L3_Operators {
    public static void main(String[] args) {
        List<String> r1 = getUsers()
          .map(String::toUpperCase)
          .toList();

        // [[1], [2,3], []] -> [1,2,3]
        List<String> r2 = getUsers()
          .flatMap(u -> getUserItems(u).stream())
          .toList();

        List<String> r3 = getUsers()
          .filter(name -> name.length() > 3)
          .toList();

        List<Integer> r4 = getUsers()
          .mapToInt(str -> str.length())
          .boxed()
          .toList();

        List<String> r5 = getUsers()
          .skip(1)
          .toList();

        List<String> r6 = getUsers()
          .limit(2)
          .toList();

        List<String> r7 = getUsers()
          .dropWhile(name -> name.length() > 3)
          .toList();

        List<String> r8 = getUsers()
          .takeWhile(name -> name.length() > 3)
          .toList();

        List<String> r9 = getUsers()
          .sorted(comparing(String::length))
          .toList();

        List<String> r10 = getUsers()
          .distinct()
          .toList();

        List<String> r11 = getUsers()
          .peek(System.out::println)
          .toList();

        List<String> r12 = getUsers()
          .mapMulti((String s, Consumer<String> consumer) -> {
              for (String userItem : getUserItems(s)) {
                  consumer.accept(userItem);
              }
          })
          .toList();
    }

    static List<String> getUserItems(String username) {
        return List.of("Box", "Phone");
    }

    static Stream<String> getUsers() {
        return Stream.of("John", "Adam", "Ewa");
    }
}
