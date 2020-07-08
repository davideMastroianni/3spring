package com.example.spring.controllers;


import com.example.spring.exceptions.PostsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PostsNotFoundAdvice {
        @ResponseBody
        @ExceptionHandler(PostsNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String PostsNotFoundHandler(PostsNotFoundException ex) {
            return ex.getMessage();
        }
    }
