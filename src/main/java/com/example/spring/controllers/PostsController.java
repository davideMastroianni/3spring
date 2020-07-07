package com.example.spring.controllers;

import com.example.spring.core.Business;
import com.example.spring.model.Comment;
import com.example.spring.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsController {

    @Autowired
    private final Business business;

    public PostsController(Business business) {
        this.business = business;
    }

    // Single item

    @GetMapping("/posts/{userId}")
    Post getPost(@PathVariable Long userId) {
        return business.getPosts(userId);
    }

    @GetMapping("/posts/{userId}/comments")
    List<Comment> getPostComments(@PathVariable Long userId) {
        return business.getComments(userId);
    }

}