package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.AddGameForm;
import com.example.ranksystem.Entity.Game;
import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Service.TimeService;
import com.example.ranksystem.repository.GameRepository;
import com.example.ranksystem.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    @PostMapping()
    public void addgame(@ModelAttribute AddGameForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {
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

        String win_user = form.getWin_user();
        String win_race = form.getWin_race();
        String lose_user = form.getLose_user();
        String lose_race = form.getLose_race();

        // DB?????? winner??? loser gamer ?????? ????????????
        Gamer winner = gamerRepository.findByNameAndRace(win_user, win_race);
        Gamer loser = gamerRepository.findByNameAndRace(lose_user, lose_race);

        double win_point = calcRating(winner.getRating(), loser.getRating(), 1);
        double lose_point = calcRating(loser.getRating(), winner.getRating(), 0);
        double game_point = win_point - winner.getRating();

        // ?????? ?????? ?????? -> ??????, Gamer ????????? ?????? ?????? ?????????????????? ????????? ?????? ?????? ??????
        gamerRepository.save_w(win_user, win_race, win_point, winner.getWins() + 1);
        gamerRepository.save_l(lose_user, lose_race, lose_point, loser.getLoses() + 1);

        // ?????? ??????
        Game newGame = new Game(win_user, win_race, lose_user, lose_race, game_point, writer);
        gameRepository.save(newGame);

        String output = win_user + "(" + win_race + "):" + lose_user + "(" + lose_race + ")";
        TimeService logTime = new TimeService();
        System.out.println(logTime.getLogTime() + output + " ?????? ??????(" + writer + ")");
        out.println("<script>alert('" + output + " ????????? ?????????????????????.'); location.href='/';</script>");

        out.flush();
        out.close();
    }

    public String makeScript(String content){
        return "\"<script>alert('" + content + "'); location.href='/';</script>\"";
    }

    public double calcRating(double myRating, double enemyRating, int isWin){
        return myRating + 40 * (isWin - calcEWR(myRating, enemyRating));
    }

    // Calculating expected winning rate
    public double calcEWR(double myRating, double enemyRating){
        return 1 / ( Math.pow(10, (enemyRating-myRating)/400) + 1);
    }
}