package com.example.forecast.services.impl;

import com.example.forecast.models.entityModels.Forecast;
import com.example.forecast.models.entityModels.User;
import com.example.forecast.models.entityModels.UserRole;
import com.example.forecast.models.entityModels.enums.RoleEnum;
import com.example.forecast.repositories.ForecastRepository;
import com.example.forecast.repositories.UserRepository;
import com.example.forecast.services.ForecastService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final UserRepository userRepository;

    public ForecastServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isOwner(String username, Long id) {

        Optional<User> caller = userRepository.findByUsername(username);

        if (caller.isEmpty()) {
            return false;
        } else {
            return isAdmin(caller.get());
        }
    }

    private boolean isAdmin(User user) {
        return user.getRoles().stream().map(UserRole::getRole).anyMatch(r -> r == RoleEnum.ADMIN);
    }
}
