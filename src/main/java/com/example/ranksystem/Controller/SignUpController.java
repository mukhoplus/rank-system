package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.SignUpForm;
import com.example.ranksystem.Entity.User;
import com.example.ranksystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/signup")
public class SignUpController {
    private UserRepository userRepository;

    @Autowired
    public SignUpController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping()
    public void signup(@ModelAttribute SignUpForm form, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String newId = form.getId();
        String newPassword = form.getPassword();
        String newName = form.getName();

        if (userRepository.existsById(newId)) {
            out.println("<script>alert('중복된 아이디입니다.'); location.href='/signup';</script>");
        } else {
            User newUser = new User(newId, newPassword, newName, false);
            userRepository.save(newUser);

            out.println("<script>alert('회원가입이 완료되었습니다.'); location.replace('/');</script>");
        }
        out.flush();
    }
}