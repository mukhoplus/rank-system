package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public ResponseEntity<User> hello(HttpServletRequest request) throws IOException {

		String curId = "";
		String curName = "";
		String curPermission = "";

		if (request.getCookies() != null) {

			Cookie[] currentCookies = request.getCookies();

			for (Cookie c : currentCookies) {
				if (c.getName().equals("id")) {
					curId = c.getValue();
					continue;
				}

				if (c.getName().equals("name")) {
					curName = c.getValue();
					continue;
				}

				if (c.getName().equals("permission")) {
					curPermission = c.getValue();
				}
			}
		}

		User returnUser = new User(curId, null, curName, curPermission);

		return new ResponseEntity<>(returnUser, HttpStatus.OK);
	}

}
