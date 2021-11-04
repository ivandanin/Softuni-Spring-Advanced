package com.example.mobilele.services;

import com.example.mobilele.models.entityModels.Model;
import com.example.mobilele.models.viewModels.ModelViewModel;
import com.example.mobilele.models.viewModels.BrandViewModel;

import java.util.List;

public interface BrandService {
    void initializeBrand();

    List<BrandViewModel> getAllBrands();

    ModelViewModel map(Model model);
}
