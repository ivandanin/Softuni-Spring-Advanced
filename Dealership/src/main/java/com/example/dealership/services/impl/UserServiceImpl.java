package com.example.dealership.services.impl;

import com.example.dealership.models.entityModels.UserEntity;
import com.example.dealership.models.serviceModels.UserServiceModel;
import com.example.dealership.repositories.UserRepository;
import com.example.dealership.services.UserService;
import com.example.dealership.user.CurrentUser;
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
        currentUser
                .setId(id)
                .setUsername(username);
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null);
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
