package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.UserEntity;
import com.example.mobilele.models.entityModels.UserRole;
import com.example.mobilele.models.entityModels.enums.RoleEnum;
import com.example.mobilele.models.serviceModels.LoginServiceModel;
import com.example.mobilele.models.serviceModels.RegisterServiceModel;
import com.example.mobilele.repos.UserEntityRepo;
import com.example.mobilele.repos.UserRoleRepo;
import com.example.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.UserEntityService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepo userRepo;
    private final UserRoleRepo userRoleRepo;
    private final CurrentUser currentUser;

    public UserEntityServiceImpl(UserEntityRepo userRepo, UserRoleRepo userRoleRepo, CurrentUser currentUser) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeRoles() {
        if (userRoleRepo.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(RoleEnum.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(RoleEnum.USER);

            userRoleRepo.saveAll(List.of(adminRole, userRole));
        }
    }

    private void initializeUsers() {
        if (userRepo.count() == 0) {
            UserRole adminRole = userRoleRepo.findByRole(RoleEnum.ADMIN);
            UserRole userRole = userRoleRepo.findByRole(RoleEnum.USER);

            UserEntity admin = new UserEntity();

            admin.setUsername("admin");
            admin.setPassword("test");
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setActive(true);

            admin.setRoles(Set.of(adminRole, userRole));
            userRepo.save(admin);

            UserEntity pesho = new UserEntity();

            pesho.setUsername("pesho");
            pesho.setPassword("test");
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setActive(true);

            pesho.setRoles(Set.of(userRole));
            userRepo.save(pesho);
        }
    }

    @Override
    public boolean login(LoginServiceModel loginServiceModel) {

        Optional<UserEntity> userEntityOpt = userRepo.findByUsername(loginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = loginServiceModel.getPassword()
                    .equals(userEntityOpt.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntityOpt.get();
                login(loggedInUser);

                loggedInUser.getRoles()
                        .forEach(r -> currentUser.addRole(r.getRole()));
            }
            return success;
        }
    }

    @Override
    public void logout() {
        currentUser.clean();
    }

    @Override
    public boolean isUsernameFree(String username) {
        return userRepo.findByUsernameIgnoreCase(username)
                .isEmpty();
    }

    @Override
    public void registerAndLogin(RegisterServiceModel serviceModel) {
        UserRole userRole = userRoleRepo.findByRole(RoleEnum.USER);

        UserEntity newUser = new UserEntity();

        newUser.setUsername(serviceModel.getUserName());
        newUser.setFirstName(serviceModel.getFirstName());
        newUser.setLastName(serviceModel.getLastName());
        newUser.setActive(true);
        newUser.setPassword(serviceModel.getPassword());
        newUser.setRoles(Set.of(userRole));

        newUser = userRepo.save(newUser);
        login(newUser);
    }

    private void login(UserEntity user) {
        currentUser.
                setLoggedIn(true).
                setUsername(user.getUsername()).
                setFirstName(user.getFirstName()).
                setLastName(user.getLastName());
    }
}
