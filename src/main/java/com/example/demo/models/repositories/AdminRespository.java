package com.example.demo.models.repositories;


import com.example.demo.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRespository extends CrudRepository<Admin, Long> {
}
