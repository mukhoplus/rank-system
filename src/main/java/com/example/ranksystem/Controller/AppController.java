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
    public String handleError(){
        return "forward:/index.html";
    }

    @GetMapping(value = {"/addgamer"})
    public String handlePemission(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String permission = "";

        if (request.getCookies() != null) {
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("permission")) {
                    permission = c.getValue();
                    break;
                }
            }
        }
        System.out.println(permission);
        if (permission != "true") {
            out.println("<script>alert('권한이 없습니다.\n운영자에게 문의하세요.'); location.href='/';</script>");
            out.flush();
            out.close();
            return "";
        } else {
            return "forward:/index.html";
        }
    }
}
