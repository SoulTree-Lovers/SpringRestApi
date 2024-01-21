package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
    private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setName("홍길동");
		user.setPhoneNumber("010-1111-1111");
		user.setEmail("rkd@naver.com");
		user.setIsKorean(true);

		// DTO -> json : 직렬화
		// json -> DTO : 역직렬화

		var json = objectMapper.writeValueAsString(user); // 직렬화
		System.out.println("json = " + json);

		var dto = objectMapper.readValue(json, UserRequest.class); // 역직렬화
		System.out.println("dto = " + dto);
	}

}
