package com.example.ranksystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping(value = {"/login", "/signup", "/addgamer", "/addgame", "/games", "/nameranking"})
    public String handleError(){
        return "forward:/index.html";
    }

}
