package com.example.helloservice.test;

import java.util.List;

import com.example.helloservice.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.helloservice.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
public class WebTest {
    private WebClient client = null;
//    @Before
//    public void init() {
//        client = WebClient.create("http://127.0.0.1:8080/");
//    }

    @Test
    public void testUserById() {
        Mono<User> result = client.get()// 请求方法,get,post...
                .uri("users/{id}", "1")// 请求相对地址以及参数
                .accept(MediaType.APPLICATION_JSON).retrieve()// 请求类型
                .bodyToMono(User.class);// 返回类型
        User user = result.block();
        System.out.println(user);
    }

    @Test
    public void testUserById2() {
        Mono<User> result2 = client.get()// 请求方法,get,post...
                .uri("api/user/{id}", "1")// 请求相对地址以及参数
                .accept(MediaType.APPLICATION_JSON).retrieve()// 请求类型
                .bodyToMono(User.class);// 返回类型
        User user2 = result2.block();
        System.out.println(user2);
    }

    @Test
    public void testAllUsers() {
        Flux<User> userFlux = client.get()
                .uri("users/")
                .accept(MediaType.APPLICATION_JSON).retrieve()// 请求类型
                .bodyToFlux(User.class);// 返回类型

        List<User> users = userFlux.collectList().block();
        System.out.println(users);
    }

    @Resource
    private UserRepository userRepository;
    @Test
    public void testInsert() {
        User user = new User();
        user.setId(1L);
        user.setAge(22);
        user.setUserName("jack");
        userRepository.save(user);
    }
}