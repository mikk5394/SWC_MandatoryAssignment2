package com.example.demo.models.repositories;


import com.example.demo.models.Student;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRespository extends CrudRepository<Student, Long>{
    List<Student> findAll();
    Student findByEmail(String email);

}
