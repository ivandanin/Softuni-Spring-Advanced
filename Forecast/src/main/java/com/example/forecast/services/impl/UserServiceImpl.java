package com.example.forecast.services.impl;

import com.example.forecast.models.entityModels.User;
import com.example.forecast.models.serviceModels.UserServiceModel;
import com.example.forecast.repositories.UserRepository;
import com.example.forecast.services.UserService;
import com.example.forecast.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null);
    }

    @Override
    public boolean register(UserServiceModel registerServiceModel) {
        User user = modelMapper.map(registerServiceModel, User.class);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
