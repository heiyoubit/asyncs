package com.example.helloservice.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {


    @GetMapping("/hi")
    public Mono<String> hi() {
        log.info("123");
        return Mono.just("{\"hi\" : \"girl\" }");
    }

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("<body>\n" +
                "\n" +
                "    <form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\n" +
                "    <input type=\"file\" name=\"fileUpload\" />\n" +
                "\n" +
                "    <input type=\"submit\" value=\"上传文件\" />\n" +
                "\n" +
                "    </form>\n" +
                "\n" +
                "</body>");
    }

    @GetMapping("/hello")
    public Mono<String> getHello() {
        return Mono.just("{ \"message\": \"Hello\" }");
    }

    @PostMapping("/hello")
    public Mono<String> postHello() {
        return Mono.just("{ \"message\": \"Hello Post\" }");
    }

}
