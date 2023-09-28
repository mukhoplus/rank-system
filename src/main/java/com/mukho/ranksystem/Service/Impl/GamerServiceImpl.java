package com.mukho.ranksystem.Service.Impl;

import com.mukho.ranksystem.Repository.GamerRepository;
import com.mukho.ranksystem.Service.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamerServiceImpl implements GamerService {

    private GamerRepository gamerRepository;

    @Autowired
    public GamerServiceImpl(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }


}
