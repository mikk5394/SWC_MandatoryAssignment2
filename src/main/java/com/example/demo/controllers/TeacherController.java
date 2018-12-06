package com.example.demo.controllers;

import com.example.demo.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/frontpage")
    public String loggedIn(){

        return "teacher/frontpage";
    }


    @GetMapping("/createCourse")
    public String createCourse(){

        return "teacher/createCourse";
    }

}
