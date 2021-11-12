package com.example.forecast.models.serviceModels;

import com.example.forecast.models.entityModels.enums.RoleEnum;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String email;
    private Set<RoleEnum> roles;

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

    public String getName() {
        return name;
    }

    public UserServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
        return this;
    }
}
