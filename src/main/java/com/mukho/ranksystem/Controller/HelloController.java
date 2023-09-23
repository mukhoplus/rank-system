package com.mukho.ranksystem.Controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.UserInfoDto;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public ResponseEntity<UserInfoDto> hello(HttpServletRequest request) throws IOException {

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

		UserInfoDto userInfo = new UserInfoDto(curId, curName, curPermission);

		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}

}
