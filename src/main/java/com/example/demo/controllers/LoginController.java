package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.User;
import com.example.demo.models.repositories.AdminRespository;
import com.example.demo.models.repositories.StudentRespository;
import com.example.demo.models.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private AdminRespository adminRespository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRespository studentRespository;

    String error = "";

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (SessionHelper.isSessionValid(request)) {
            User user = (User) session.getAttribute("user");

            return "";
        }
        model.addAttribute("error", error);
        error = "";
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(defaultValue = "") String email,
                        @RequestParam(defaultValue = "") String password,
                        HttpServletRequest request) {


        HttpSession session = request.getSession();

        if (adminRespository.findByEmail(email) != null) {
            User user = adminRespository.findByEmail(email);
            if (user.getPassword().equals(password)) {
                session.setAttribute("admin", user);
                return "redirect:/admin";
            }
        } else if (teacherRepository.findByEmail(email) != null) {
            User user = teacherRepository.findByEmail(email);
            if (user.getPassword().equals(password)) {
                session.setAttribute("teacher", user);
                return "redirect:/teacher";
            }
        } else if (studentRespository.findByEmail(email) != null) {
            User user = studentRespository.findByEmail(email);
            if (user.getPassword().equals(password)) {
                session.setAttribute("student", user);
                return "redirect:/student";
            }
        }

        error = "Email or password is invalid";

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        SessionHelper.logout(request);

        return "redirect:/login";
    }
}