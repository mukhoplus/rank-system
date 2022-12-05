package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public User hello(HttpServletRequest request) throws IOException{

        String curId = "";
        String curName = "";
        String curPermission = "";

        if (request.getCookies() != null) {
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("id")) {
                    curId = c.getValue();
                } else if(c.getName().equals("name")){
                    curName = c.getValue();
                } else if(c.getName().equals("permission")){
                    curPermission = c.getValue();
                }
            }
        }

        boolean returnPermission = curPermission == "false" ? false : true;
        User returnUser = new User(curId, null, curName, returnPermission);

        return returnUser;
    }
}
