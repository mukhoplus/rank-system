package com.example.ranksystem.Controller;

import com.example.ranksystem.Service.TimeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LogoutController {

    @DeleteMapping(value="/logout")
    public boolean logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        if(request.getCookies() != null){
            String curId = "";
            String curName = "";
            String curPermission = "";
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("id")) {
                    curId = c.getValue();
                } else if(c.getName().equals("name")){
                    curName = c.getValue();
                }
            }

            TimeService logTime = new TimeService();
            System.out.println(logTime.getLogTime() + curId + "(" + curName + ") 로그아웃");

            response.addCookie(delCookie("id", null));
            response.addCookie(delCookie("name", null));
            response.addCookie(delCookie("permission", null));
            return true;
        } else{
            return false;
        }
    }

    public Cookie delCookie(String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }
}