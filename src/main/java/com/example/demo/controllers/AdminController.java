package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.models.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

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

    @GetMapping("/coursesWithList")
    public String coursesWithList(HttpServletRequest request, Model model){

        if (SessionHelper.isAdmin(request)){

            List<Course> courses = new ArrayList<>();
            courses.addAll(courseRepository.findAll());

            List<Course> coursesWithWaitingList = new ArrayList<>();

            for (int i = 0; i < courses.size(); i++){
                if (!courses.get(i).getStudentWaitingList().isEmpty()){
                    coursesWithWaitingList.add(courses.get(i));
                }
            }

            model.addAttribute("course", coursesWithWaitingList);


            return "adminDirectory/coursesWithList";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @GetMapping("/signedStudents/{id}")
    public String signedStudentList(@PathVariable Long id, HttpServletRequest request, Model model){

        if (SessionHelper.isAdmin(request)){

            Optional<Course> course = (courseRepository.findById(id));
            Course c = course.get();


            List<Student> studentsWaiting = new ArrayList<>();

            for (int i = 0; i < c.getStudentWaitingList().size(); i++){
                studentsWaiting.add(c.getStudentWaitingList().get(i));
            }

            model.addAttribute("student", studentsWaiting);
            model.addAttribute("course", c);


            return "adminDirectory/signedStudents";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @PostMapping("/signedStudents")
    public String signedStudentList(HttpServletRequest request, @ModelAttribute Course course, @ModelAttribute Student student){

        if (SessionHelper.isAdmin(request)){
        course.getStudentWaitingList().remove(student);
        courseRepository.save(course);
            return "redirect:/admin";
        } else {
            return "redirect:/login";
        }

    }

}
