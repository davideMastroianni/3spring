package com.example.spring.exceptions;

public class PostsNotFoundException extends RuntimeException {
    public PostsNotFoundException(Long id) {

        super("Could not find post with id " + id);
    }

}
