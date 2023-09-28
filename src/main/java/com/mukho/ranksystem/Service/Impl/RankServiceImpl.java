package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Repository.NameRankingRepository;
import com.mukho.ranksystem.Repository.RankingRepository;
import com.mukho.ranksystem.Service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    private RankingRepository rankRepository;
    private NameRankingRepository nameRankingRepository;

    @Autowired
    public RankServiceImpl(RankingRepository rankRepository, NameRankingRepository nameRankingRepository) {
        this.rankRepository = rankRepository;
        this.nameRankingRepository = nameRankingRepository;
    }



}
