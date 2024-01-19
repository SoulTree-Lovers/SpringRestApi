package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 기본 getter, setter 등 메소드를 자동으로 만들어 줌
@AllArgsConstructor // 멤버변수를 모두 포함한 생성자
@NoArgsConstructor // 기본 생성자
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}
