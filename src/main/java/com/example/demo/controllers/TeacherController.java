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

@Controller
public class TeacherController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teacher")
    public String index(HttpServletRequest request){

        if(SessionHelper.isTeacher(request)){
            return "teacherDirectory/teacher";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }

    }

    @GetMapping("/viewCoursesTeacher")
    public String viewCourse(Model model, HttpServletRequest request){


        if (SessionHelper.isTeacher(request)){

            model.addAttribute("computerscience", courseRepository.findAllByStudyProgram("ComputerScience"));
            model.addAttribute("webdevelopment", courseRepository.findAllByStudyProgram("WebDevelopment"));
            model.addAttribute("softwaredevelopment", courseRepository.findAllByStudyProgram("SoftwareDevelopment"));
            model.addAttribute("itsecurity", courseRepository.findAllByStudyProgram("ITSecurity"));

            return "teacherDirectory/viewCoursesTeacher";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @GetMapping("/editCourse")
    public String editCourse(@RequestParam(value = "id", defaultValue = "1") Long id, Model model, HttpServletRequest request){

        if (SessionHelper.isTeacher(request)){

            model.addAttribute("course", courseRepository.findById(id));
            model.addAttribute("teacher", teacherRepository.findAll());

            return "teacherDirectory/editCourse";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @PostMapping("/editCourse")
    public String editCourse(@ModelAttribute Course course){

        courseRepository.save(course);

        return "redirect:/teacher";
    }


    @GetMapping("/createCourse")
    public String createCourse(Model model, HttpServletRequest request){

        if (SessionHelper.isTeacher(request)){
            model.addAttribute("course", new Course());
            model.addAttribute("teacher", teacherRepository.findAll());

            return "teacherDirectory/createCourse";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @PostMapping("/createCourse")
    public String creatCourse(@ModelAttribute Course course){

        courseRepository.save(course);

        return "redirect:/teacher";
    }

}
