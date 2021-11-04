package com.example.mobilele.repos;

import com.example.mobilele.models.entityModels.UserRole;
import com.example.mobilele.models.entityModels.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findByRole(RoleEnum role);
}
