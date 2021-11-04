package com.example.mobilele.models.serviceModels;

public class LoginServiceModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
