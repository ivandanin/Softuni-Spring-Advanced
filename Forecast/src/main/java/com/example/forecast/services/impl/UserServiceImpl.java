package com.example.forecast.services.impl;

import com.example.forecast.models.entityModels.User;
import com.example.forecast.models.entityModels.UserRole;
import com.example.forecast.models.entityModels.enums.RoleEnum;
import com.example.forecast.models.serviceModels.UserServiceModel;
import com.example.forecast.repositories.UserRepository;
import com.example.forecast.repositories.UserRoleRepository;
import com.example.forecast.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final ForecastUserServiceImpl forecastUserService;


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, ForecastUserServiceImpl forecastUserService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.forecastUserService = forecastUserService;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleRepository.findByRole(RoleEnum.ADMIN);
            UserRole userRole = userRoleRepository.findByRole(RoleEnum.USER);

            User admin = new User();
            admin
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setName("Admin");

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);

            User pesho = new User();
            pesho
                    .setUsername("pesho")
                    .setPassword(passwordEncoder.encode("12345"))
                    .setName("pesho");

            pesho.setRoles(Set.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(RoleEnum.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(RoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }


    @Override
    public void registerAndLogin(UserServiceModel registerServiceModel) {
        UserRole userRole = userRoleRepository.findByRole(RoleEnum.USER);

        User newUser = new User();

        newUser.setUsername(registerServiceModel.getUsername())
                .setName(registerServiceModel.getName())
                .setPassword(passwordEncoder.encode(registerServiceModel.getPassword()))
                .setRoles(Set.of(userRole));

        newUser = userRepository.save(newUser);

        UserDetails principal = forecastUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    }
