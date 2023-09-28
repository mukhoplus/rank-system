package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Dto.AddGamerFormDto;
import com.mukho.ranksystem.Model.Gamer;
import com.mukho.ranksystem.Repository.GamerRepository;
import com.mukho.ranksystem.Service.GamerService;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class GamerServiceImpl implements GamerService {

    private GamerRepository gamerRepository;

    @Autowired
    public GamerServiceImpl(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }

    @Override
    public List<String> getGamers() {
        return gamerRepository.findNameList();
    }

    @Override
    public Boolean addGamer(AddGamerFormDto form, String adder, PrintWriter out) {
        boolean isAdd = false;

        String inputName = form.getName();

        if (inputName == null || inputName.equals("")) {
            out.println(makeScript("이름를 입력해주세요."));
        } else if (gamerRepository.existsByName(inputName)) {
            out.println(makeScript("이미 등록된 선수입니다."));
        } else {
            String[] races = {"Terran", "Protoss", "Zerg"};

            for (String race : races) {
                Gamer gamer = new Gamer(inputName, race);
                gamerRepository.save(gamer);
            }

            TimeUtil logTime = TimeUtil.getInstance();
            System.out.println(logTime.getLogTime() + inputName + " 선수 추가(" + adder + ")");
            out.println("<script>alert('" + inputName + " 선수가 추가되었습니다.'); location.href='/';</script>");
            isAdd = true;
        }

        return isAdd;
    }

    public String makeScript(String content) {
        return "\"<script>alert('" + content + "'); location.href='/addgamer';</script>\"";
    }

}
