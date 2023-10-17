package com.for_comprehension.function.l7_custom_collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

class L7_CustomCollector {
    public static void main(String[] args) {
        List<Integer> result = Stream.of(1).collect(toUnmodifiableList(() -> new LinkedList<>()));
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList(Supplier<List<T>> collectionFactory) {
        return new ToUnmodifiableListCollector<>(collectionFactory);
    }

    private record ToUnmodifiableListCollector<T>(Supplier<List<T>> collectionFactory)
      implements Collector<T, ArrayList<T>, List<T>> {

        @Override
        public Supplier<ArrayList<T>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<ArrayList<T>, T> accumulator() {
            return ArrayList::add;
        }

        @Override
        public BinaryOperator<ArrayList<T>> combiner() {
            return (ts, ts2) -> {
                ts.addAll(ts2);
                return ts;
            };
        }

        @Override
        public Function<ArrayList<T>, List<T>> finisher() {
            return ts -> {
                List<T> result = collectionFactory.get();
                result.addAll(ts);
                return Collections.unmodifiableList(result);
            };
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }
    }
}
