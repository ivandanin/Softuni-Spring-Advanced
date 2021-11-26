package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Brand;
import com.example.mobilele.repos.BrandRepo;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;

    public BrandServiceImpl(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    @Override
    public void initializeBrand() {
        if (brandRepo.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");

            brandRepo.save(ford);
        }
    }
}
