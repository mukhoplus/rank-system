package com.mukho.ranksystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukho.ranksystem.Dto.AddGameFormDto;
import com.mukho.ranksystem.Model.Game;
import com.mukho.ranksystem.Model.Gamer;
import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Repository.GamerRepository;
import com.mukho.ranksystem.Utils.TimeUtil;

@RestController
@RequestMapping(value = "/addgame")
public class AddGameController {

	private GameRepository gameRepository;
	private GamerRepository gamerRepository;

	@Autowired(required = false)
	public AddGameController(GameRepository gameRepository, GamerRepository gamerRepository) {
		this.gameRepository = gameRepository;
		this.gamerRepository = gamerRepository;
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

		String winUser = form.getWinUser();
		String winRace = form.getWinRace();
		String loseUser = form.getLoseUser();
		String loseRace = form.getLoseRace();

		// DB에서 winner와 loser gamer 정보 가져오기
		Gamer winner = gamerRepository.findByNameAndRace(winUser, winRace);
		Gamer loser = gamerRepository.findByNameAndRace(loseUser, loseRace);

		double win_point = calcRating(winner.getRating(), loser.getRating(), 1);
		double lose_point = calcRating(loser.getRating(), winner.getRating(), 0);
		double game_point = win_point - winner.getRating();

		// 선수 정보 갱신 -> 이때, Gamer 객체에 직접 값을 변경시키려는 시도를 하면 오류 발생
		gamerRepository.saveWinner(winUser, winRace, win_point, winner.getWins() + 1);
		gamerRepository.saveLoser(loseUser, loseRace, lose_point, loser.getLoses() + 1);

		// 전적 추가
		Game newGame = new Game(winUser, winRace, loseUser, loseRace, game_point, writer);
		gameRepository.save(newGame);

		String output = winUser + "(" + winRace + "):" + loseUser + "(" + loseRace + ")";
		TimeUtil logTime = TimeUtil.getInstance();
		System.out.println(logTime.getLogTime() + output + " 전적 추가(" + writer + ")");
		out.println(makeScript(output + " 전적이 추가되었습니다."));

		out.flush();
		out.close();

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public String makeScript(String content) {
		return "\"<script>alert('" + content + "'); location.href='/';</script>\"";
	}

	public double calcRating(double myRating, double enemyRating, int isWin) {
		return myRating + 40 * (isWin - calcEWR(myRating, enemyRating));
	}

	// Calculating expected winning rate
	public double calcEWR(double myRating, double enemyRating) {
		return 1 / (Math.pow(10, (enemyRating - myRating) / 400) + 1);
	}
}