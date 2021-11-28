package com.example.forecast.repositories;

import com.example.forecast.models.entityModels.User;
import com.example.forecast.models.entityModels.UserRole;
import com.example.forecast.models.entityModels.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

}
