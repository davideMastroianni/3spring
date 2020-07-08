package com.example.spring.controllers;

import com.example.spring.services.PostsService;
import com.example.spring.entities.Comment;
import com.example.spring.entities.Post;
import com.example.spring.entities.Users;
import com.example.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    // Single item

    @GetMapping("/posts/{postId}")
    Post getPostById(@PathVariable Long postId) {
        return postsService.getPostById(postId);
    }


    @GetMapping("/posts")
    List<Post> getPosts() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Users> user = userRepository.findByUsername(userDetails.getUsername());
        return postsService.getPosts(user.get().getId());
    }

    @GetMapping("/posts/{postId}/comments")
    List<Comment> getPostComments(@PathVariable Long postId) {
        return postsService.getComments(postId);
    }

}