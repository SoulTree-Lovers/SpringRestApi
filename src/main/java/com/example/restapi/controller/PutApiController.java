package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public void put(
            @RequestBody UserRequest userRequest
    ) {
            log.info("Request : {}", userRequest);  // {}에 뒤에 오는 userRequest.toString()이 매핑된다.
            // System.out.println()은 메소드별로 각각 실행해서 서버에 오버헤드를 줄 수 있기 때문에, 로그백 방식을 사용하는 것이 좋다.
    }
}
