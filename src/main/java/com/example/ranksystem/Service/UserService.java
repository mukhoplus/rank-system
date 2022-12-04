package com.example.ranksystem.Service;

import com.example.ranksystem.repository.UserRepository;

import javax.transaction.Transactional;

public class UserService {
    public UserRepository userRepository;

    public boolean isIdDuplication(String id){
        return userRepository.existsById(id);
    }

}
