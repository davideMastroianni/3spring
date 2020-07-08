package com.example.spring.controllers;

import java.util.List;
import java.util.Optional;

import com.example.spring.repositories.UserRepository;
import com.example.spring.exceptions.UsersNotFoundException;
import com.example.spring.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/user")
    public String user() {
        return "user";
    }
//
//    @RequestMapping(value = "userId", method = RequestMethod.GET)
//    public ModelAndView user(Model model) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Optional<Users> user = repository.findByUsername(userDetails.getUsername());
//        ModelAndView mav = new ModelAndView("userId");
//        mav.addObject("messages", user.get().getId());
//        return mav;
//    }

}