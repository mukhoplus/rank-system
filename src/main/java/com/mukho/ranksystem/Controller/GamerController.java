package com.mukho.ranksystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mukho.ranksystem.Service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mukho.ranksystem.Dto.AddGamerFormDto;

@RestController
@RequestMapping(value = "/gamer")
public class GamerController {

	private GamerService gamerService;

	@Autowired
	public GamerController(GamerService gamerService) {
		this.gamerService = gamerService;
	}

	@GetMapping
	public ResponseEntity<List<String>> getGamers() {
		return new ResponseEntity<>(gamerService.getGamers(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addGamer(@ModelAttribute AddGamerFormDto form, HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String adder = session.getAttribute("id").toString();

		boolean isAdd = gamerService.addGamer(form, adder, out);

		out.flush();
		out.close();

		if (isAdd) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}