package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Dto.LoginFormDto;
import com.mukho.ranksystem.Dto.SignUpFormDto;
import com.mukho.ranksystem.Dto.UserInfoDto;
import com.mukho.ranksystem.Model.User;
import com.mukho.ranksystem.Projection.UserInfoProjection;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mukho.ranksystem.Repository.UserRepository;
import com.mukho.ranksystem.Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.PrintWriter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(LoginFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        HttpSession session = request.getSession();

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

            if (!passwordEncoder.matches(inputPassword, cmpUser.getPassword())) {
                out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다.", "login"));
            } else {
                session.setAttribute("id", cmpUser.getId());
                session.setAttribute("name", cmpUser.getName());
                session.setAttribute("permission", cmpUser.getPermission());

                TimeUtil logTime = TimeUtil.getInstance();
                System.out.println(logTime.getLogTime() + cmpUser.getId() + "(" + cmpUser.getName() + ") 로그인");
                out.println("<script>alert('" + cmpUser.getName() + "님 반갑습니다!'); location.href='/';</script>");
                isLogin = true;
            }
        }

        return isLogin;
    }

    @Override
    public boolean signup(SignUpFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        HttpSession session = request.getSession();

        boolean isSignUp = false;

        String newId = form.getId();
        String newPassword = form.getPassword();
        String newName = form.getName();

        if (userRepository.existsById(newId)) {
            out.println("<script>alert('중복된 아이디입니다.'); location.href='/signup';</script>");
        } else {
            String encodedPassword = passwordEncoder.encode(newPassword);
            User newUser = new User(newId, encodedPassword, newName, "");
            userRepository.save(newUser);

            session.setAttribute("id", newUser.getId());
            session.setAttribute("name", newUser.getName());
            session.setAttribute("permission", newUser.getPermission());

            TimeUtil logTime = TimeUtil.getInstance();
            System.out.println(logTime.getLogTime() + newId + "(" + newName + ") 회원가입");
            out.println("<script>alert('회원가입이 완료되었습니다.'); location.replace('/');</script>");
            isSignUp = true;
        }

        return isSignUp;
    }

    @Override
    public List<UserInfoProjection> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public int updateUser(UserInfoDto info) {
        return userRepository.updateUser(info.getId(), info.getPermission());
    }

    @Override
    public boolean isIdDuplication(String id){
        return userRepository.existsById(id);
    }

    public String makeScript(String content, String url) {
        return "\"<script>alert('" + content + "'); location.href='/" + url + "';</script>\"";
    }

}
