package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.repositories.CourseRepository;
import com.example.demo.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/admin")
    public String loggedIn(HttpServletRequest request){

        if(SessionHelper.isAdmin(request)){
            return "adminDirectory/admin";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @GetMapping("/signedStudents")
    public String signedStudents(HttpServletRequest request, Model model){

        if (SessionHelper.isAdmin(request)){



            return "adminDirectory/signedStudents";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }

    }
}
