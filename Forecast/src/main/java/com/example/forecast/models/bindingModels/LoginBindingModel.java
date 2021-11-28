package com.example.forecast.models.bindingModels;

import javax.validation.constraints.Size;

public class LoginBindingModel {

    @Size(min = 3, max = 20, message = "Username length is between 3 and 20 symbols!")
    private String username;
    @Size(min = 5, message = "Password must have minimum 5 symbols!")
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
