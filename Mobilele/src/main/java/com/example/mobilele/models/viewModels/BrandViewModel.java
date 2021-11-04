package com.example.mobilele.models.viewModels;

import com.example.mobilele.models.serviceModels.ModelServiceModel;
import com.example.mobilele.services.ModelService;

import java.util.List;

public class BrandViewModel {
    private String name;
    private List<ModelViewModel> models;

    public BrandViewModel() {
    }

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }
}
