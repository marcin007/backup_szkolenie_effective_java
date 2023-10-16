package com.for_comprehension.function.l1_optional;

import java.util.function.Function;

class L1_MonadExample {

    public static void main(String[] args) {
        Monad.from("foo")
          .map(s -> s.toUpperCase())
          .map(s -> "-BAR");
    }

    public static class Monad<T> {
        private T value;

        Monad(T value) {
            this.value = value;
        }

        public static <T> Monad<T> from(T value) {
            return new Monad<>(value);
        }
        // computational context

        public <R> Monad<R> map(Function<T, R> action) {
            // process computational context
            return Monad.from(action.apply(value));
        }


    }
}
