package com.example.dealership.repositories;

import com.example.dealership.models.entityModels.UserEntity;
import com.example.dealership.models.serviceModels.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
