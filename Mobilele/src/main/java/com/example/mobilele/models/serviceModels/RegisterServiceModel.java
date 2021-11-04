package com.example.mobilele.models.serviceModels;

public class RegisterServiceModel {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;

    public String getFirstName() {
        return firstName;
    }

    public RegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public RegisterServiceModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
