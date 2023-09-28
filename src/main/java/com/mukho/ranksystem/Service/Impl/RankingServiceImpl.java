package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Dto.NameRankDto;
import com.mukho.ranksystem.Dto.RankDto;
import com.mukho.ranksystem.Repository.NameRankingRepository;
import com.mukho.ranksystem.Repository.RankingRepository;
import com.mukho.ranksystem.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    private RankingRepository rankRepository;
    private NameRankingRepository nameRankingRepository;

    @Autowired
    public RankingServiceImpl(RankingRepository rankRepository, NameRankingRepository nameRankingRepository) {
        this.rankRepository = rankRepository;
        this.nameRankingRepository = nameRankingRepository;
    }

    @Override
    public List<RankDto> getRanking() {
        return rankRepository.getRanking();
    }

    @Override
    public List<NameRankDto> getNameRanking() {
        return nameRankingRepository.getNameRanking();
    }

}
