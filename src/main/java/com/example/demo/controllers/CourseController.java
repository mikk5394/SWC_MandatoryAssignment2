package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/allCourses")
    public String courses(){
        List<Course> listOfCourses = courseRepository.findAll();

        return "";
    }
}
