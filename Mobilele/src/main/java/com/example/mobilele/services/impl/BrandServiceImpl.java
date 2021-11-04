package com.example.mobilele.services.impl;

import com.example.mobilele.models.entityModels.Brand;
import com.example.mobilele.models.entityModels.Model;
import com.example.mobilele.models.viewModels.ModelViewModel;
import com.example.mobilele.repos.BrandRepo;
import com.example.mobilele.models.viewModels.BrandViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.mobilele.services.BrandService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepo brandRepo, ModelMapper modelMapper) {
        this.brandRepo = brandRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepo.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");

            brandRepo.save(ford);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepo.findAll()
                .stream()
                .map(brand -> {
                    BrandViewModel brandViewModel = new BrandViewModel()
                            .setName(brand.getName());

                    brandViewModel
                            .setModels(brand.getModels()
                                    .stream()
                                    .map(this::map)
                                    .collect(Collectors.toList()));
                    return brandViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ModelViewModel map(Model model) {
        return modelMapper.map(model, ModelViewModel.class);
    }
}
