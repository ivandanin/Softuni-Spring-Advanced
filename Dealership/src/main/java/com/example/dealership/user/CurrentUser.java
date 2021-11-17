package com.example.dealership.user;

import com.example.dealership.models.entityModels.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private Set<UserRole> roles;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public CurrentUser setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }
}
