package com.example.mobilele.repos;

import com.example.mobilele.models.entityModels.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    Optional<Object> findByUsernameIgnoreCase(String username);
}
