package com.example.enhance;

import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class EnhanceStreamFactory<E> {
    public static <E> EnhancedStream<E> newEnhancedStream(Stream<E> stream) {
        return (EnhancedStream<E>) Proxy.newProxyInstance(
                EnhancedStream.class.getClassLoader(),
                new Class<?>[] {EnhancedStream.class},
                new EnhancedStreamHandler<>(stream)
        );
    }
}
