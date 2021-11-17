package com.example.dealership.models.serviceModels;

import com.example.dealership.models.entityModels.UserRole;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String password;
    private String lastName;
    private String email;
    private Set<UserRole> roles;

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }
}
