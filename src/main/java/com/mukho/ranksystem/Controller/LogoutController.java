package com.mukho.ranksystem.Controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Utils.TimeUtil;

@RestController
@RequestMapping("logout")
public class LogoutController {

	@DeleteMapping
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		try {
			String curId = session.getAttribute("id").toString();
			String curName = session.getAttribute("name").toString();

			TimeUtil logTime = TimeUtil.getInstance();
			System.out.println(logTime.getLogTime() + curId + "(" + curName + ") 로그아웃");

			session.invalidate();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}