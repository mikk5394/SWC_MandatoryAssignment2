

package com.example.demo.models.repositories;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    //Ingen grund til at returnere en liste her da ingen kan ha' samme email
    User findByEmail(String email);
}

