package com.example.mobilele.repos;

import com.example.mobilele.models.entityModels.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {
}
