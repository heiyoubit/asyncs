package com.example.helloservice.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.helloservice.model.User;
import com.example.helloservice.repository.UserRepository;

import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * UserHandler
 * 用户操作的业务逻辑
 * @author suncht
 *
 */
@Service
public class UserHandler {
    private List<String> NOT_FOUND_LIST = Arrays.asList("not found");
    private User EMPTY_USER = new User();

    @Resource
    private UserRepository userRepository;


    public Mono<ServerResponse> handleGetUserById(ServerRequest request) {
        long userId = Long.valueOf(request.pathVariable("id"));
        Optional<User> user = userRepository.findById(userId);
        return ServerResponse.ok().body(Mono.just(user.isPresent() ? user.get() : EMPTY_USER), User.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> handleGetUsers(ServerRequest request) {
        List<User> all = userRepository.findAll();
        return ServerResponse.ok().body(Mono.just(ObjectUtils.isEmpty(all) ? NOT_FOUND_LIST : all), List.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> handleInsert(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);

        return ServerResponse.ok().body(userMono.doOnNext(user -> {userRepository.save(user);}), User.class);
    }

    public Mono<ServerResponse> handlePatch(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().body(userMono.doOnNext(user -> {userRepository.save(user);}), User.class);
    }

    public Mono<ServerResponse> handleDelete(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().body(userMono.doOnNext(user -> {userRepository.delete(user);}), User.class);
    }

    public Mono<ServerResponse> handleUpload(ServerRequest request) {
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(
                request.body(BodyExtractors.toMultipartData()).map(parts -> {
                    Map<String, Part> map = parts.toSingleValueMap();
                    // ‘files’ 为客户端上传文件key
                    FilePart filePart = (FilePart) map.get("fileUpload");
                    try {
                        // 第一个参数是上传文件的前缀，可以随便起名字
                        Path tempFile = Files.createTempFile("upload_file", filePart.filename());
                        File dest = tempFile.toFile();
                        filePart.transferTo(dest);
                        return filePart.filename();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                }).map(filename -> {
                    if (!StringUtils.isEmpty(filename)) {
                        return "{\"message \": \"OK\"}";
                    } else {
                        return "{\"message\" : \"error\"}";
                    }
                }), String.class
        );
    }
}