package com.example.demo.controllers;

import com.example.demo.models.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/teacher")
    public String index(){

        return "teacherDirectory/teacher";
    }


}
