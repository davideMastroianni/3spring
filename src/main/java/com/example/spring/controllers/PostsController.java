package com.example.spring.controllers;

import com.example.spring.core.Business;
import com.example.spring.entities.Comment;
import com.example.spring.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/posts/{postId}")
    Post getPostById(@PathVariable Long postId) {
        return business.getPostById(postId);
    }


    @GetMapping("/posts")
    List<Post> getPosts(@RequestParam Long user) {
        return business.getPosts(user);
    }

    @GetMapping("/posts/{postId}/comments")
    List<Comment> getPostComments(@PathVariable Long postId) {
        return business.getComments(postId);
    }

}