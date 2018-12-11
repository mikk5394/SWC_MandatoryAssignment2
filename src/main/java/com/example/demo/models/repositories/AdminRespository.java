package com.example.demo.models.repositories;


import com.example.demo.models.Admin;
import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRespository extends CrudRepository<Admin, Long> {
    List<Admin> findAll();
    Admin findByEmail(String email);
}
