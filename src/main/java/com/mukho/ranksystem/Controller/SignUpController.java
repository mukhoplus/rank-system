package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Dto.SignUpFormDto;
import com.mukho.ranksystem.Model.User;
import com.mukho.ranksystem.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mukho.ranksystem.Utils.TimeUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/signup")
public class SignUpController {

	private UserRepository userRepository;

	@Autowired
	public SignUpController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public ResponseEntity<?> signup(@ModelAttribute SignUpFormDto form, HttpServletResponse response) throws
		IOException {
		boolean isSignUp = false;

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String newId = form.getId();
		String newPassword = form.getPassword();
		String newName = form.getName();

		if (userRepository.existsById(newId)) {
			out.println("<script>alert('중복된 아이디입니다.'); location.href='/signup';</script>");
		} else {
			User newUser = new User(newId, newPassword, newName, "false");
			userRepository.save(newUser);

			response.addCookie(makeCookie("id", newUser.getId()));
			response.addCookie(makeCookie("name", newUser.getName()));
			response.addCookie(makeCookie("permission", newUser.getPermission()));

			TimeUtil logTime = TimeUtil.getInstance();
			System.out.println(logTime.getLogTime() + newId + "(" + newName + ") 회원가입");
			out.println("<script>alert('회원가입이 완료되었습니다.'); location.replace('/');</script>");
			isSignUp = true;
		}
		out.flush();
		out.close();

		if (isSignUp) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public Cookie makeCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(600);
		cookie.setPath("/");
		return cookie;
	}

}