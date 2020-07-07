package com.example.spring.core;

import com.example.spring.model.Comment;
import com.example.spring.model.Post;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class Business {

    private final RestTemplate restTemplate;

    public Business(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("http://jsonplaceholder.typicode.com").build();
    }

    public Post getPosts(Long userId) {
        String uri = "/posts/"+userId;
        Post post = restTemplate.getForObject(uri, Post.class);
        return post;
    }

    public List<Comment> getComments(Long userId) {
        String uri = "/posts/"+userId+"/comments";
        ResponseEntity<List<Comment>> responseComment = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
        List<Comment> commentList = responseComment.getBody();
        return commentList;
    }
}
