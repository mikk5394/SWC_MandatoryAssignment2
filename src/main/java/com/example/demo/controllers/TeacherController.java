package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeacherController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/teacher")
    public String index(HttpServletRequest request){

        if(SessionHelper.isTeacher(request)){
            return "teacherDirectory/teacher";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }

    }


}
