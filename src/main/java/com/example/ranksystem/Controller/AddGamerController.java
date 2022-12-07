package com.example.ranksystem.Controller;

import com.example.ranksystem.Entity.AddGamerForm;
import com.example.ranksystem.Entity.Gamer;
import com.example.ranksystem.Service.TimeService;
import com.example.ranksystem.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping(value = "/addgamer")
public class AddGamerController {
    private GamerRepository gamerRepository;

    @Autowired
    public AddGamerController(GamerRepository gamerRepository){
        this.gamerRepository = gamerRepository;
    }

    @PostMapping()
    public void addgamer(@ModelAttribute AddGamerForm form, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String adder = "";

        if (request.getCookies() != null) {
            Cookie[] currentCookies = request.getCookies();

            for (Cookie c : currentCookies) {
                if (c.getName().equals("id")) {
                    adder = c.getValue();
                    break;
                }
            }
        }

        String inputName = form.getName();
        if (inputName == "") {
            out.println(makeScript("이름를 입력해주세요."));
        } else if (gamerRepository.existsByName(inputName)) {
            out.println(makeScript("이미 등록된 선수입니다."));
        } else {
            String[] races = {"Terran", "Protoss", "Zerg"};
            for (String race : races) {
                Gamer gamer = new Gamer(inputName, race);
                gamerRepository.save(gamer);
            }
            TimeService logTime = new TimeService();
            System.out.println(logTime.getLogTime() + inputName + " 선수 추가(" + adder + ")");
            out.println("<script>alert('" + inputName + "선수가 추가되었습니다.'); location.href='/';</script>");
        }

        out.flush();
        out.close();
    }

    public String makeScript(String content){
        return "\"<script>alert('" + content + "'); location.href='/addgamer';</script>\"";
    }
}