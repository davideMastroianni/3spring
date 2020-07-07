package com.example.spring.exceptions;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Long id) {
        super("Could not find user with id " + id);
    }
}
