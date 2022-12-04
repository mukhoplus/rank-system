package com.example.ranksystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value="/logout")
public class LogoutController {

    @GetMapping()
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean isCorrect = false;

        if(request.getCookies() != null){
            Cookie[] currentCookies = request.getCookies();

            for(Cookie c: currentCookies) {
                if (c.getName().equals("id") && c.getValue() != null) {
                    isCorrect = true;
                    break;
                }
            }
        }

        if(isCorrect){
            response.addCookie(delCookie("id", null));
            response.addCookie(delCookie("name", null));
            response.addCookie(delCookie("permission", null));

            out.println(makeScriptMain("로그아웃되었습니다."));
        }
        else{
            out.println(makeScriptMain("잘못된 접근입니다."));
        }

        out.flush();
    }

    public Cookie delCookie(String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }

    public String makeScriptMain(String content){
        return "\"<script>alert('" + content + "'); location.href='/';</script>\"";
    }
}