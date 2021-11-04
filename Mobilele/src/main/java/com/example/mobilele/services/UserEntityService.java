package com.example.mobilele.services;

import com.example.mobilele.models.serviceModels.LoginServiceModel;
import com.example.mobilele.models.serviceModels.RegisterServiceModel;

public interface UserEntityService {
    void initializeUsersAndRoles();

    boolean login(LoginServiceModel loginServiceModel);

    boolean isUsernameFree(String username);

    void registerAndLogin(RegisterServiceModel serviceModel);

    void logout();
}
