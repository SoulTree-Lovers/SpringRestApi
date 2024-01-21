package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // json 형식 응답만 내려줌.
//@Controller // html 형식의 응답을 내려줌
@RequestMapping("/api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
    @GetMapping("")
//    @RequestMapping(path = "", method = RequestMethod.GET) // @GetMapping과 동일
    public ResponseEntity<UserRequest> user() {
        var user = new UserRequest();
        user.setName("홍길동");
        user.setPhoneNumber("010-1111-1111");
        user.setEmail("rkd@naver.com");
        user.setIsKorean(true);

        log.info("user: {}", user); // 로그백 메시지

        var response = ResponseEntity
                .status(HttpStatus.CREATED) // status code를 임의로 설정할 수 있음.
                .header("x-custom", "hi") // header도 추가 가능.
                .body(user);

        return response;
    }
}
