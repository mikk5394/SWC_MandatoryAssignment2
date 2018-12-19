package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.Course;
import com.example.demo.models.repositories.CourseRepository;
import com.example.demo.models.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/allCourses")
    public String courses(Model model){
        List<Course> listOfCourses = courseRepository.findAll();

        model.addAttribute("courses", listOfCourses);

        return "courseSignedUp";
    }

}
