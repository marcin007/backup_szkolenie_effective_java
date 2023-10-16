package com.for_comprehension.function.l1_optional;

import java.util.Optional;

class L2_OptionalExample {

    public static void main(String[] args) {
        // imperative
        String nullableResult = findUserById(4).orElse(null);
        if (nullableResult != null) {
            String upperCase = nullableResult.toUpperCase();
            if (upperCase != null) {
                String postfixxed = upperCase + "::";
                if (postfixxed != null) {
                    nullableResult = "DEFAULT";
                }
            }
        }

        // declarative
        String result = findUserById(4)
          .map(String::toUpperCase)
          .map(u -> u + "::")
          .orElse("DEFAULT");
    }

    private static Optional<String> findUserById(int id) {
        if (id == 4) {
            return Optional.of("John");
        } else {
            return Optional.empty();
        }

    }
}
