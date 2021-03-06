package com.example.dealership.models.bindingModels;

public class RegisterBindingModel {

    private String name;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public RegisterBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterBindingModel setUsername(String username) {
        this.username = username;
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
