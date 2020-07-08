package com.example.spring.services;

import com.example.spring.entities.Users;
import com.example.spring.exceptions.UsersNotFoundException;
import com.example.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsersNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsersNotFoundException(username + " not found."));
        UserDetails userDetails = User.withUsername(user.get().getUsername()).password(user.get().getPassword()).authorities("USER").build();
//        UserDetails userDetails = user.map(UserDetailsImpl::new).get();
        return userDetails;
    }
}
