package com.geonung.spring.boot.web;

import com.geonung.spring.boot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json으로 반환 =ResponseBody
public class HelloController {

    @GetMapping("/hello") //get 요청
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam ("name") String name, @RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount);
    }

}
