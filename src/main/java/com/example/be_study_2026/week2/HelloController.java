package com.example.be_study_2026.week2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "환영합니다!";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name") String name) {
        return name + "님, 안녕하세요!";
    }

    @GetMapping("/json-test")
    public Menu returnMenu() {
        return new Menu("아이스 아메리카노", 4500);
    }

}
