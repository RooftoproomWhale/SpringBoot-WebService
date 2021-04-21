package com.geonung.spring.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json으로 반환 =ResponseBody
public class HelloController {
    @GetMapping("/hello") //get 요청
    public String hello()
    {
        return "hello";
    }
}
