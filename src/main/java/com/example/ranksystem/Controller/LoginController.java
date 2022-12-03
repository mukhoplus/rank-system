package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.LoginForm;
import com.example.ranksystem.Entity.User;
import com.example.ranksystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping()
    public void login(@ModelAttribute LoginForm form, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String inputId = form.getId();
        String inputPassword = form.getPassword();

        if(inputId == ""){
            out.println(makeScript("아이디를 입력해주세요."));
        } else if(inputPassword == ""){
            out.println(makeScript("비밀번호를 입력해주세요."));
        } else if (!userRepository.existsById(inputId) ) {
            out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다."));
        } else {
            User cmpUser = userRepository.findById(inputId);

            if(!inputPassword.equals(cmpUser.getPassword())){
                out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다."));
            } else{
                /*
                세션 처리
                 */
                out.println("<script>location.href='/';</script>");
            }
        }
        out.flush();
    }
    
    public String makeScript(String content){
        return "\"<script>alert('" + content + "'); location.href='/login';</script>\"";
    }
}