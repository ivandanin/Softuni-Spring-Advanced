package com.example.forecast.services;

import com.example.forecast.models.serviceModels.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    boolean register(UserServiceModel registerServiceModel);
}
