package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.LoginForm;
import com.example.ranksystem.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping(value = {"/login", "/signup", "/signup/*"})
    public String handleError(){
        return "forward:/index.html";
    }

}