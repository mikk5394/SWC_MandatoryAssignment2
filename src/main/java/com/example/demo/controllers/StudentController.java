package com.example.demo.controllers;

import com.example.demo.Service.SessionHelper;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.models.repositories.CourseRepository;
import com.example.demo.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/student")
    public String loggedIn(HttpServletRequest request){

        if(SessionHelper.isStudent(request)){
            return "studentDirectory/student";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @GetMapping("/courseSignUp")
    public String courseSignUp(Model model, HttpServletRequest request){

        if(SessionHelper.isStudent(request)){

            model.addAttribute("computerscience", courseRepository.findAllByStudyProgram("ComputerScience"));
            model.addAttribute("webdevelopment", courseRepository.findAllByStudyProgram("WebDevelopment"));
            model.addAttribute("softwaredevelopment", courseRepository.findAllByStudyProgram("SoftwareDevelopment"));
            model.addAttribute("itsecurity", courseRepository.findAllByStudyProgram("ITSecurity"));

            return "studentDirectory/courseSignUp";

        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @PostMapping("/courseSignUp")
    public String courseSignUp(@RequestParam(value = "id", defaultValue = "1") Long id, HttpServletRequest request) {

        if (SessionHelper.isStudent(request)) {

            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");

            Optional<Course> optCourse = courseRepository.findById(id);
            Course course = optCourse.get();

            course.addStudentToWaitingList(student);

            courseRepository.save(course);

            return "redirect:/student";
        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

    @GetMapping("/courseSignedUpList")
    public String showSignedList(Model model, HttpServletRequest request){

        if (SessionHelper.isStudent(request)){

            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");

            List<Course> courses = new ArrayList<>();
            courses.addAll(courseRepository.findAll());

            List<Course> coursesForStudent = new ArrayList<>();

            for (int i = 0; i < courses.size(); i++) {
                for (int k = 0; k < courses.get(i).getStudentWaitingList().size(); k++) {
                    if (courses.get(i).getStudentWaitingList().get(k).getId() == student.getId()) {
                        coursesForStudent.add(courses.get(i));

                    }
                }
            }

            model.addAttribute("course", coursesForStudent);

            return "studentDirectory/courseSignedUpList";


        } else {
            SessionHelper.logout(request);
            return "redirect:/login";
        }
    }

}
