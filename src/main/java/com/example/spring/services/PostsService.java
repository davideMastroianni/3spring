package com.example.spring.services;

import com.example.spring.entities.Comment;
import com.example.spring.entities.Post;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class PostsService {

    private final RestTemplate restTemplate;

    public PostsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("http://jsonplaceholder.typicode.com").build();
    }

    public Post getPostById(Long postId) {
        String uri = "/posts/"+postId;
        Post post = restTemplate.getForObject(uri, Post.class);
        return post;
    }

    public List<Post> getPosts(Long userId) {
        String uri = "/posts?userId="+userId;
        ResponseEntity<List<Post>> responseComment = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
        List<Post> postList = responseComment.getBody();
        return postList;
    }

    public List<Comment> getComments(Long postId) {
        String uri = "/posts/"+postId+"/comments";
        ResponseEntity<List<Comment>> responseComment = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
        List<Comment> commentList = responseComment.getBody();
        return commentList;
    }
}
