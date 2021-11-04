package com.example.mobilele.models.bindingModels;

public class RegisterBindingModel {

    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String userName;

    public String getFirstName() {
        return firstName;
    }

    public RegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getUsername() {
        return userName;
    }

    public RegisterBindingModel setUsername(String userName) {
        this.userName = userName;
        return this;
    }
}
