package com.example.demo.Service;

import com.example.demo.models.Admin;
import com.example.demo.models.Student;
import com.example.demo.models.Teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHelper {

    public static boolean isSessionValid(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("user") != null;
    }

    public static boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("admin") != null) {
            if (session.getAttribute("admin") instanceof Admin) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isTeacher(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("teacher") != null) {
            if (session.getAttribute("teacher") instanceof Teacher) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isStudent(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("student") != null) {
            if (session.getAttribute("student") instanceof Student) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }
}