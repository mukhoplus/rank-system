package com.example.ranksystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/main")
    public String test() {
        return "Hello, Mukho!";
    }
}
