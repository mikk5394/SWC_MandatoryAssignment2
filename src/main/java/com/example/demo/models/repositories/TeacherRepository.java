package com.example.demo.models.repositories;


import com.example.demo.models.Teacher;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    List<Teacher> findAll();
    Teacher findByEmail(String email);
}
