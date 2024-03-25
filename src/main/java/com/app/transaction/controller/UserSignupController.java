package com.app.transaction.controller;

import com.app.transaction.entity.UserSignup;
import com.app.transaction.service.UserSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignupController {

    @Autowired
    private UserSignupService userSignupService;

    @PostMapping("/api/users/signup")
    public ResponseEntity<?> signUp(@Validated @RequestBody UserSignup userSignup) {
        userSignupService.signUp(userSignup);
        return ResponseEntity.status(HttpStatus.CREATED).body("User signed up successfully.");
    }
}
