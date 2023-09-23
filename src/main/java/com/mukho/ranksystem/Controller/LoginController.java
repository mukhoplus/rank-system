package com.mukho.ranksystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.LoginFormDto;
import com.mukho.ranksystem.Model.User;
import com.mukho.ranksystem.Repository.UserRepository;
import com.mukho.ranksystem.Utils.TimeUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	private UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public ResponseEntity<?> login(@ModelAttribute LoginFormDto form, HttpServletResponse response) throws IOException {
		boolean isLogin = false;

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String inputId = form.getId();
		String inputPassword = form.getPassword();

		if (inputId.equals("")) {
			out.println(makeScript("아이디를 입력해주세요."));
		} else if (inputPassword.equals("")) {
			out.println(makeScript("비밀번호를 입력해주세요."));
		} else if (!userRepository.existsById(inputId)) {
			out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다."));
		} else {
			User cmpUser = userRepository.findById(inputId);

			if (!inputPassword.equals(cmpUser.getPassword())) {
				out.println(makeScript("아이디 또는 비밀번호를 잘못 입력했습니다."));
			} else {
				response.addCookie(makeCookie("id", cmpUser.getId()));
				response.addCookie(makeCookie("name", cmpUser.getName()));
				response.addCookie(makeCookie("permission", cmpUser.getPermission()));

				TimeUtil logTime = TimeUtil.getInstance();
				System.out.println(logTime.getLogTime() + cmpUser.getId() + "(" + cmpUser.getName() + ") 로그인");
				out.println("<script>alert('" + cmpUser.getName() + "님 반갑습니다!'); location.href='/';</script>");
				isLogin = true;
			}
		}
		out.flush();
		out.close();

		if (isLogin) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	public Cookie makeCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(1200);
		cookie.setPath("/");
		return cookie;
	}

	public String makeScript(String content) {
		return "\"<script>alert('" + content + "'); location.href='/login';</script>\"";
	}

}