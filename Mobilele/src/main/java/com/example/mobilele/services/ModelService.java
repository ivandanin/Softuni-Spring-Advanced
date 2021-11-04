package com.example.mobilele.services;

import com.example.mobilele.models.entityModels.Model;

public interface ModelService {
    void initializeModels();

    Model findById(Long id);
}
