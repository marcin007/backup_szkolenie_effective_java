package com.for_comprehension.function.l3_stream;

import java.util.List;
import java.util.stream.Stream;

class L3_Debugging {

    public static void main(String[] args) {
        // debugger: trace current stream chain
        List.of("aa", "bb", "cccc", "ddd")
          .stream()
          .map(i -> i.toUpperCase())
          .filter(i -> i.length() > 2)
          .flatMap(i -> Stream.generate(() -> i).limit(10))
          .forEach(a -> {
              throw new RuntimeException();
          });
    }
}
