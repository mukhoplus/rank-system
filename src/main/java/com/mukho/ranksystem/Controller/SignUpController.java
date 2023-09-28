package com.mukho.ranksystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mukho.ranksystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.SignUpFormDto;
import com.mukho.ranksystem.Model.User;
import com.mukho.ranksystem.Utils.TimeUtil;

@RestController
@RequestMapping(value = "/signup")
public class SignUpController {

	private UserService userService;

	@Autowired
	public SignUpController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<?> signup(@ModelAttribute SignUpFormDto form, HttpServletRequest request, HttpServletResponse response) throws
		IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		boolean isSignUp = userService.signup(form, request, response, out);

		out.flush();
		out.close();

		if (isSignUp) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}