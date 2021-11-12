package com.example.forecast.services;

import com.example.forecast.models.serviceModels.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(Long id, String username);

    void logout();

    boolean register(UserServiceModel registerServiceModel);
}
