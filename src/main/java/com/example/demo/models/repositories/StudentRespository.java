package com.example.demo.models.repositories;


import com.example.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRespository extends CrudRepository<Student, Long>{
}
