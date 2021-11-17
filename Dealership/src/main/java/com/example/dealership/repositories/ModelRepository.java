package com.example.dealership.repositories;

import com.example.dealership.models.entityModels.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
