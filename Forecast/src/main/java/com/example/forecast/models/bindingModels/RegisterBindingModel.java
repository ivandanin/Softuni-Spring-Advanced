package com.example.forecast.models.bindingModels;

import com.example.forecast.models.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBindingModel {

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 symbols!")
    @UniqueUsername
    @NotNull
    private String username;

    @Size(min = 2, max = 20, message = "Name length must be between 2 and 20 symbols!")
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @Size(min = 5, message = "Password length must be at least 5 symbols!")
    @NotNull
    private String password;

    @Size(min = 5, message = "Confirm password must match password!")
    @NotNull
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public RegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public RegisterBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
