package com.for_comprehension.function.l5_lambda_exceptions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.for_comprehension.function.l5_lambda_exceptions.LambdaUtils.sneaky;

class L5_LambdaExceptions {

    public static void main(String[] args) {
        List<Integer> result = Stream.of(1, 2, 3, 4)
          .map(sneaky(i -> process(i)))
          .toList();
    }

    public static <T> T process(T input) throws IOException {
        if (ThreadLocalRandom.current().nextInt(5) == 1) {
            throw new IOException(":(");
        }
        return input;
    }
}
