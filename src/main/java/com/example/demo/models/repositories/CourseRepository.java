package com.example.demo.models.repositories;

import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();

}
