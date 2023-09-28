package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Dto.LoginFormDto;
import com.mukho.ranksystem.Dto.SignUpFormDto;
import com.mukho.ranksystem.Model.User;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukho.ranksystem.Repository.UserRepository;
import com.mukho.ranksystem.Service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(LoginFormDto form, HttpServletResponse response, PrintWriter out) {
        boolean isLogin = false;

        String inputId = form.getId();
        String inputPassword = form.getPassword();

        if (inputId.equals("")) {
            out.println(makeScript("아이디를 입력해주세요.", "login"));
        } else if (inputPassword.equals("")) {
            out.println(makeScript("비밀번호를 입력해주세요.", "login"));
        } else if (!userRepository.existsById(inputId)) {
            out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다.", "login"));
        } else {
            User cmpUser = userRepository.findById(inputId);

            if (!inputPassword.equals(cmpUser.getPassword())) {
                out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다.", "login"));
            } else {
                response.addCookie(makeCookie("id", cmpUser.getId(), 1200));
                response.addCookie(makeCookie("name", cmpUser.getName(), 1200));
                response.addCookie(makeCookie("permission", cmpUser.getPermission(), 1200));

                TimeUtil logTime = TimeUtil.getInstance();
                System.out.println(logTime.getLogTime() + cmpUser.getId() + "(" + cmpUser.getName() + ") 로그인");
                out.println("<script>alert('" + cmpUser.getName() + "님 반갑습니다!'); location.href='/';</script>");
                isLogin = true;
            }
        }

        return isLogin;
    }

    @Override
    public boolean signup(SignUpFormDto form, HttpServletResponse response, PrintWriter out) {
        boolean isSignUp = false;

        String newId = form.getId();
        String newPassword = form.getPassword();
        String newName = form.getName();

        if (userRepository.existsById(newId)) {
            out.println("<script>alert('중복된 아이디입니다.'); location.href='/signup';</script>");
        } else {
            User newUser = new User(newId, newPassword, newName, "");
            userRepository.save(newUser);

            response.addCookie(makeCookie("id", newUser.getId(), 600));
            response.addCookie(makeCookie("name", newUser.getName(), 600));
            response.addCookie(makeCookie("permission", newUser.getPermission(), 600));

            TimeUtil logTime = TimeUtil.getInstance();
            System.out.println(logTime.getLogTime() + newId + "(" + newName + ") 회원가입");
            out.println("<script>alert('회원가입이 완료되었습니다.'); location.replace('/');</script>");
            isSignUp = true;
        }

        return isSignUp;
    }

    @Override
    public boolean isIdDuplication(String id){
        return userRepository.existsById(id);
    }

    public Cookie makeCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        return cookie;
    }

    public String makeScript(String content, String url) {
        return "\"<script>alert('" + content + "'); location.href='/" + url + "';</script>\"";
    }

}
