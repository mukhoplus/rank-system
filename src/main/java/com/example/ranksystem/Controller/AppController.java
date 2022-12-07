package com.example.ranksystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AppController {

    @GetMapping(value = {"/login", "/signup", "/addgamer"})
    public String handleError(){
        return "forward:/index.html";
    }

}
