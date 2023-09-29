package com.mukho.ranksystem.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();

		String curId = "";
		String curName = "";
		String curPermission = "";

		UserInfoDto userInfo;

		try {
			curId = session.getAttribute("id").toString();
			curName = session.getAttribute("name").toString();
			curPermission = session.getAttribute("permission").toString();
		} catch (Exception e) {
			curId = "";
			curName = "";
			curPermission = "";
		} finally {
			userInfo = new UserInfoDto(curId, curName, curPermission);
		}

		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}

}
