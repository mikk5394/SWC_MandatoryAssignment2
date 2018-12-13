package com.example.demo.models.repositories;

import com.example.demo.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
    List<Course> findAllByStudyProgram(String s);

}
