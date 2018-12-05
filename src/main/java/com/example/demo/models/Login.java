package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table (name = "login")
public class Login {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }


}
