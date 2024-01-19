package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    // Pass Variable
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age, // Integer는 null이 할당될 수 있고, int는 기본값이 0이라서, 여기선 주소값이므로 int형이 좋다.
            @PathVariable boolean isMan // boolean도 마찬가지로 primitive 타입으로 받는 것이 좋다.
    ) {
        System.out.println("echo message = " + msg);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);

        // TODO: 대문자로 변환해서 리턴
        String result = msg.toUpperCase();
        return result;
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear, // 이 방식 또는
            @RequestParam(name = "issued-month") String issuedMonth, // 이 방식 사용 권장
            @RequestParam String issued_day // 추천하지 않는 방식
    ) {
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issued_day);
    }

    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    // 객체로 받을 때는 주소에 적힌 파라미터의 변수명이 객체의 멤버변수명과 일치해야 한다.
    // -> 보통 캐멀캐이스로 맞추는 것이 자바 컨벤션이다.
    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
    }

    // TODO: parameter 2가지를 받는다. int 형태로 받아서 두 수의 덧셈, 곱셈을 반환하는 메소드 2개를 작성해라.

    // http://localhost:8080/api/add?a=10&b=20
    @GetMapping(path = "/add")
    public int add(
            @RequestParam int a,
            @RequestParam int b
    ) {
        int sum = a+b;
        System.out.println("a + b = " + sum);
        return sum;
    }

    // http://localhost:8080/api/mul?a=10&b=20
    @GetMapping(path = "/mul")
    public int mul(
            @RequestParam int a,
            @RequestParam int b
    ) {
        int mul = a*b;
        System.out.println("a * b = " + mul);
        return mul;
    }

    // TODO: String, boolean 타입도 받아보기.
    // http://localhost:8080/api/profile?name=승민&age=25&isMan=true
    @GetMapping(path = "/profile")
    public void profile(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam boolean isMan
    ) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);
    }

}
