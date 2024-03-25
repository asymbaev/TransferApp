package com.app.transaction.service;

import com.app.transaction.entity.UserSignup;
import com.app.transaction.repository.UserSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignupService {

    @Autowired
    private UserSignupRepository userSignupRepository;

    public void signUp(UserSignup userSignup) {
        userSignupRepository.save(userSignup);
    }
}
