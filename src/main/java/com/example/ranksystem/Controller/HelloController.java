package com.example.ranksystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/main")
    public String test(HttpServletRequest request) throws IOException{
        String text = "반갑습니다";
        String curName = "";

        if (request.getCookies() != null) {
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("name") && c.getValue() != null) {
                    curName = c.getValue();
                    break;
                }
            }
        }

        if (curName == null || curName.equals("")) {
            return text + ".";
        }
        else{
            return text + ", " + curName + "님!";
        }
    }
}
