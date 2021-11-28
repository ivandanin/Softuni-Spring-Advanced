package com.example.forecast.services;

import com.example.forecast.models.serviceModels.UserServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void registerAndLogin(UserServiceModel registerServiceModel);
}
