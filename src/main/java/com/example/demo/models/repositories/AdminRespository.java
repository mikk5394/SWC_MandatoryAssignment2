package com.example.demo.models.repositories;


import com.example.demo.models.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRespository extends CrudRepository<Admin, Long> {
    List<Admin> findAll();
}
