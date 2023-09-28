package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Dto.AddGameFormDto;
import com.mukho.ranksystem.Model.Game;
import com.mukho.ranksystem.Model.Gamer;
import com.mukho.ranksystem.Repository.GameRepository;
import com.mukho.ranksystem.Repository.GamerRepository;
import com.mukho.ranksystem.Service.GameService;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamerRepository gamerRepository;

    public GameServiceImpl(GameRepository gameRepository, GamerRepository gamerRepository) {
        this.gameRepository = gameRepository;
        this.gamerRepository = gamerRepository;
    }

    @Override
    public List<Game> getGames() {
        return gameRepository.getGames();
    }

    @Override
    public String addGame(AddGameFormDto form, String writer) {

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

        return output;
    }

    @Override
    public int getRelative(String user1, String race1, String user2, String race2) {
        return gameRepository.getRelative(user1, race1, user2, race2);
    }

    public double calcRating(double myRating, double enemyRating, int isWin) {
        return myRating + 40 * (isWin - calcEWR(myRating, enemyRating));
    }

    // Calculating expected winning rate
    public double calcEWR(double myRating, double enemyRating) {
        return 1 / (Math.pow(10, (enemyRating - myRating) / 400) + 1);
    }

}
