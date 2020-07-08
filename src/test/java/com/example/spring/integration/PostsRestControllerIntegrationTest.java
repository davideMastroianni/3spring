package com.example.spring.integration;

import com.example.spring.controllers.PostsController;
import com.example.spring.entities.Post;
import com.example.spring.repositories.UserRepository;
import com.example.spring.services.PostsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostsController.class)
public class PostsRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostsService service;

    @MockBean
    private UserRepository userRepository;

    @Test
    @WithMockUser(username = "Bret", password = "password", roles = "USER")
    public void givenPostId_whenGetPostById_thenReturnPostJson()
            throws Exception {

        Post post_1 = new Post((long) 1, (long) 2, "Title", "Body");

        given(service.getPostById((long) 1)).willReturn(post_1);

        mvc.perform(get("/api/posts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(post_1.getId().intValue())));
    }
}