package com.for_comprehension.function.l1_optional;

import java.util.InputMismatchException;
import java.util.Optional;

class L3_OptionalOperatorsExample {

    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("foo");
        Optional<String> o2 = Optional.ofNullable(null);

        String result = findUserById(4)
          .map(String::toUpperCase)
          .orElse("DEFAULT");

        Optional<String> result_flat = findUserById(4)
          .flatMap(i -> findUserById(42));

        Optional<String> result_filtered = findUserById(4)
          .filter(s -> s.length() > 1);

        String r1 = findUserById(4).orElse("cośtam");
        String r2 = findUserById(4).orElseGet(() -> getDefault());
        String r3 = findUserById(4).orElseThrow(() -> new InputMismatchException());

        String r4 = findUserById(4).get();
        String r5 = findUserById(4).orElseThrow();

        boolean r6 = findUserById(4).isPresent();
        Optional<String> r7 = findUserById(12983712).or(() -> findUserById(4));
        findUserById(4).ifPresent(System.out::println);
        findUserById(4).ifPresentOrElse(System.out::println, () -> System.out.println("Hello!"));
    }

    private static Optional<String> findUserById(int id) {
        if (id == 4) {
            return Optional.of("John");
        } else {
            return Optional.empty();
        }
    }

    private static String getDefault() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "foo";
    }

    private static void foo() {
        throw new RuntimeException();
    }
}
