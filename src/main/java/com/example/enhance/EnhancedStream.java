package com.example.enhance;

import java.util.Comparator;
import java.util.function.*;
import java.util.stream.Stream;

public interface EnhancedStream<T> extends Stream<T> {
    EnhancedStream<T> distinct(ToIntFunction<T> hashCode,
                               BiPredicate<T, T> equals,
                               BinaryOperator<T> merger);


    @Override
    EnhancedStream<T> filter(Predicate<? super T> predicate);
    @Override
    <R> EnhancedStream<R> map(
            Function<? super T, ? extends R> mapper);
    @Override
    <R> EnhancedStream<R> flatMap(
            Function<? super T, ? extends Stream<? extends R>> mapper);
    @Override
    EnhancedStream<T> distinct();
    @Override
    EnhancedStream<T> sorted();
    @Override
    EnhancedStream<T> sorted(Comparator<? super T> comparator);
    @Override
    EnhancedStream<T> peek(Consumer<? super T> action);
    @Override
    EnhancedStream<T> limit(long maxSize);
    @Override
    EnhancedStream<T> skip(long n);
    @Override
    EnhancedStream<T> takeWhile(Predicate<? super T> predicate);
    @Override
    EnhancedStream<T> dropWhile(Predicate<? super T> predicate);
    @Override
    EnhancedStream<T> sequential();
    @Override
    EnhancedStream<T> parallel();
    @Override
    EnhancedStream<T> unordered();
    @Override
    EnhancedStream<T> onClose(Runnable closeHandler);
}
