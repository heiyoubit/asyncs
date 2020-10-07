package com.example.helloservice.test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxTest {
    public static void main(String[] args) {
        Flux.just("abc", "efgh", "12345")
                .filter(s-> s.length() > 3)
                .map(s -> s.concat("@gmail.com"))
                .subscribe(log::info);
    }
}
