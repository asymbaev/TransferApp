package com.app.transaction.service;

import com.app.transaction.entity.User;
import com.app.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public User addUser(User user) {
        // Save the user to the database
        return userRepository.save(user);
    }
    public List<User> listUsers() {
        // Retrieve all users from the database
        return userRepository.findAll();
    }
    // Method to delete a user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    // Method to delete a user by email
    public void deleteUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.delete(user);
        }
    }
    public List<User> findMatchingUsers() {
        // Retrieve all users from the database
        List<User> allUsers = userRepository.findAll();

        // Map to store users based on entered amount
        Map<Double, List<User>> amountMap = new HashMap<>();

        // Group users based on entered amount
        for (User user : allUsers) {
            double amount = user.getEnteredAmount();
            if (!amountMap.containsKey(amount)) {
                amountMap.put(amount, new ArrayList<>());
            }
            amountMap.get(amount).add(user);
        }

        // List to store matching users
        List<User> matchingUsers = new ArrayList<>();

        // Iterate through the map and find users with the same entered amount
        for (List<User> userList : amountMap.values()) {
            if (userList.size() == 2) { // Only considered users who entered the same amount
                // Adding both users to the list of matching users
                matchingUsers.addAll(userList);
            }
        }
        return matchingUsers;

    }
}
