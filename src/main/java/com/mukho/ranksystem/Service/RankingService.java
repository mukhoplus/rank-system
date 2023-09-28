package com.mukho.ranksystem.Service;

import com.mukho.ranksystem.Dto.NameRankDto;
import com.mukho.ranksystem.Dto.RankDto;

import java.util.List;

public interface RankingService {

    List<RankDto> getRanking();

    List<NameRankDto> getNameRanking();

}
