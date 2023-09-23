package com.mukho.ranksystem.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukho.ranksystem.Repository.UserRepository;
import com.mukho.ranksystem.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    public boolean isIdDuplication(String id){
        return userRepository.existsById(id);
    }

}
