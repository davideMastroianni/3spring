package com.example.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private final UserRepository repository;

    public UsersController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<Users> all() {
        return repository.findAll();
    }

    // Single item

    @GetMapping("/users/{id}")
    Users one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
    }

}