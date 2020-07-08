package com.example.spring.controllers;

import com.example.spring.core.Business;
import com.example.spring.entities.Comment;
import com.example.spring.entities.Post;
import com.example.spring.entities.Users;
import com.example.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostsController {

    @Autowired
    private UserRepository userRepository;

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
    List<Post> getPosts() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Users> user = userRepository.findByUsername(userDetails.getUsername());
        return business.getPosts(user.get().getId());
    }

    @GetMapping("/posts/{postId}/comments")
    List<Comment> getPostComments(@PathVariable Long postId) {
        return business.getComments(postId);
    }

}