package com.example.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private @Id Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean isActive;
    private String roles;

}
