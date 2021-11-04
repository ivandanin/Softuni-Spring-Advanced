package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Brand;
import com.example.mobilele.models.entityModels.Model;
import com.example.mobilele.models.entityModels.enums.CategoryEnum;
import com.example.mobilele.repos.BrandRepo;
import com.example.mobilele.repos.ModelRepo;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.ModelService;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final BrandRepo brandRepo;
    private final ModelRepo modelRepo;

    public ModelServiceImpl(BrandRepo brandRepo, ModelRepo modelRepo) {
        this.brandRepo = brandRepo;
        this.modelRepo = modelRepo;
    }

    @Override
    public void initializeModels() {
        Brand ford = brandRepo.findByName("Ford")
                .orElseThrow(IllegalArgumentException::new);

        Model fiesta = new Model();
        fiesta
                .setName("Fiesta")
                .setCategory(CategoryEnum.CAR)
                .setImageUrl("https://www.autoevolution.com/news/2020-ford-fiesta-rs-probably-confirmed-by-broad-grin-125727.html#agal_0")
                .setStartYear(1976)
                .setBrand(ford);

        Model escort = new Model();
        escort
                .setName("Escort")
                .setCategory(CategoryEnum.CAR)
                .setImageUrl("https://en.wikipedia.org/wiki/Ford_Escort_RS_Cosworth#/media/File:1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg")
                .setStartYear(1967)
                .setEndYear(2002)
                .setBrand(ford);

        modelRepo.saveAll(List.of(fiesta, escort));

    }

    @Override
    public Model findById(Long id) {
        return modelRepo.findById(id).orElse(null);
    }
}
