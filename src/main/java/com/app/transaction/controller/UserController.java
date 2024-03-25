package com.app.transaction.controller;

import com.app.transaction.entity.User;
import com.app.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;


    // Endpoint to list all users
    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    // Endpoint to add a new user
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
    // Endpoint to delete a user by email
    @DeleteMapping("/email/{email}")
    public void deleteUserByEmail(@PathVariable String email) {
        userService.deleteUserByEmail(email);
    }

    @GetMapping("/matching")
    public List<User> getMatchingUsers() {
        // Call the UserService to find matching users
        return userService.findMatchingUsers();
    }

}
