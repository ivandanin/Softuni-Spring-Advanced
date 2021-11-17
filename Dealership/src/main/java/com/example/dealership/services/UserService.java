package com.example.dealership.services;

import com.example.dealership.models.serviceModels.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);
    void login(Long id, String username);
    void logout();
    boolean register(UserServiceModel userServiceModel);

}
