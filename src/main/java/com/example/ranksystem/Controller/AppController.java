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

    @GetMapping(value = {"/login", "/signup"})
    public String handleError(HttpServletRequest request, HttpServletResponse response) throws IOException {

        boolean isLogin = false;
        String curName = "";

        if (request.getCookies() != null) {
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("name") && c.getValue() != null) {
                    isLogin = true;
                    curName = c.getValue();
                    break;
                }
            }
        }

        if (isLogin) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(makeScriptMain(curName + "님이 로그인 상태입니다."));
            out.flush();
            return "";
        }

        return "forward:/index.html";

    }

    public String makeScriptMain(String content){
        return "\"<script>alert('" + content + "'); location.href='/';</script>\"";
    }

}