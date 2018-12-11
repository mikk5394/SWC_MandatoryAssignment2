package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
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
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/allCourses")
    public String courses(Model model){
        List<Course> listOfCourses = courseRepository.findAll();

        model.addAttribute("courses", listOfCourses);

        return "allCourses";
    }

    @GetMapping("/createCourse")
    public String createCourse(Model model, HttpServletRequest request){

        if (SessionHelper.isTeacher(request)){
            model.addAttribute("course", new Course());
            model.addAttribute("teacher", teacherRepository.findAll());

            return "teacherDirectory/createCourse";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/createCourse")
    public String creatCourse(@ModelAttribute Course course){

        courseRepository.save(course);

        return "redirect:/teacher";
    }

    @GetMapping("/editCourse")
    public String editCourse(HttpServletRequest request){

        if (SessionHelper.isTeacher(request)){

            return "teacherDirectory/editCourse";
        } else {
            return "redirect:/login";
        }
    }

}
