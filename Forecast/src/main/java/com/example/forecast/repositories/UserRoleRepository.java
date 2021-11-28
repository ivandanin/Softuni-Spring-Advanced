package com.example.forecast.repositories;

import com.example.forecast.models.entityModels.UserRole;
import com.example.forecast.models.entityModels.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(RoleEnum role);
}
