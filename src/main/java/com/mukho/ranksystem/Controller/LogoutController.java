package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Utils.TimeUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@RestController
@RequestMapping("logout")
public class LogoutController {

	@DeleteMapping
	public ResponseEntity<Boolean> logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		if (request.getCookies() != null) {
			String curId = "";
			String curName = "";

			Cookie[] currentCookies = request.getCookies();

			for (Cookie c : currentCookies) {
				if (c.getName().equals("id")) {
					curId = c.getValue();
					continue;
				}

				if (c.getName().equals("name")) {
					curName = c.getValue();
				}
			}

			TimeUtil logTime = TimeUtil.getInstance();
			System.out.println(logTime.getLogTime() + curId + "(" + curName + ") 로그아웃");

			response.addCookie(delCookie("id", null));
			response.addCookie(delCookie("name", null));
			response.addCookie(delCookie("permission", null));

			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}

	public Cookie delCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		return cookie;
	}

}