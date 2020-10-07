package com.example.enhance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>() {{
            add(new User(1, "test1"));
            add(new User(2, "test2"));
            add(new User(2, "test2"));
            add(new User(3, "test3"));
            add(new User(3, "test4"));
        }};
        EnhancedStream<User> enhancedStream = EnhanceStreamFactory.newEnhancedStream(users.stream());

        List<User> collect = enhancedStream.distinct().collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}
