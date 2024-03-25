package com.app.transaction.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private double enteredAmount;

    //Constructors
    public User() {

    }

    public User(String name, String email, double enteredAmount) {
        this.name = name;
        this.email = email;
        this.enteredAmount = enteredAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getEnteredAmount() {
        return enteredAmount;
    }

    public void setEnteredAmount(double enteredAmount) {
        this.enteredAmount = enteredAmount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enteredAmount=" + enteredAmount +
                '}';
    }
}
