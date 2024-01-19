package com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // snake case로 매핑한다. (body의 json 변수 이름이 snake case인 경우 사용)
public class UserRequest {
    private String name;
    private String phoneNumber;
    private String email;
    private Boolean isKorean; // primitive type으로 선언하면 snake case를 구별할 수 없기 때문에, 객체 타입으로 선언해야 함.
}
