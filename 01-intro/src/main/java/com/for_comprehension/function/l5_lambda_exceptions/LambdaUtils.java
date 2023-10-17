package com.for_comprehension.function.l5_lambda_exceptions;

import java.util.function.Function;

class LambdaUtils {

    static <T extends Exception, R> R rethrow(Exception exception) throws T {
        throw (T) exception;
    }

    static <T, R> Function<T, R> sneaky(ThrowingFunction<T, R> mapper) {
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception e) {
                return rethrow(e);
            }
        };
    }

    static <T, R> Function<T, R> unchecked(ThrowingFunction<T, R> mapper) {
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }

    static <T> T todo() {
        throw new RuntimeException("TODO");
    }
}
