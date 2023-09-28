package com.mukho.ranksystem.Service;

import com.mukho.ranksystem.Dto.AddGamerFormDto;

import java.io.PrintWriter;
import java.util.List;

public interface GamerService {

    List<String> getGamers();

    Boolean addGamer(AddGamerFormDto form, String adder, PrintWriter out);

}
