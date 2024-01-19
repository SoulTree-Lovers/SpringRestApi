package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(@RequestBody BookRequest bookRequest ) { // Body로 들어오는 데이터를 해당 객체로 매핑시켜주는 어노테이션이다.
        System.out.println("bookRequest = " + bookRequest);
        return bookRequest; // json 형태로 리턴
    }

    @PostMapping("/user")
    public UserRequest post(@RequestBody UserRequest userRequest ) { // Body로 들어오는 데이터를 해당 객체로 매핑시켜주는 어노테이션이다.
        System.out.println("bookRequest = " + userRequest);
        return userRequest; // json 형태로 리턴
    }
}
