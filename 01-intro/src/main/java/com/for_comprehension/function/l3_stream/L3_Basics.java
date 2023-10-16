package com.for_comprehension.function.l3_stream;

import java.util.List;
import java.util.stream.Stream;

class L3_Basics {

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3);

        /* intermediate method! :(
        s1.map(i -> {
            System.out.println(i);
            return i;
        });
        */

//        s1.forEach(System.out::println);
//        s1.forEach(System.out::println); stream has already been operated upon or closed

        long processed = List.of(1, 2, 3, 4)
          .stream()
          .map(i -> {
              System.out.println("sending email to client id: " + i);
              return i;
          }).count();

        System.out.println(processed);
    }
}
