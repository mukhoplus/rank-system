package com.mukho.ranksystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mukho.ranksystem.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mukho.ranksystem.Dto.AddGameFormDto;

@RestController
@RequestMapping(value = "/game")
public class GameController {

	private GameService gameService;

	@Autowired(required = false)
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	public ResponseEntity<List> getGames() {
		return new ResponseEntity<>(gameService.getGames(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addGame(@ModelAttribute AddGameFormDto form, HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String writer = "";

		if (request.getCookies() != null) {
			Cookie[] currentCookies = request.getCookies();

			for (Cookie c : currentCookies) {
				if (c.getName().equals("id")) {
					writer = c.getValue();
					break;
				}
			}
		}

		String output = gameService.addGame(form, writer);
		out.println(makeScript(output + " 전적이 추가되었습니다."));

		out.flush();
		out.close();

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public String makeScript(String content) {
		return "\"<script>alert('" + content + "'); location.href='/';</script>\"";
	}

}