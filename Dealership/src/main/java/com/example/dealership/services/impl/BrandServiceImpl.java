package com.example.dealership.services.impl;

import com.example.dealership.models.entityModels.ModelEntity;
import com.example.dealership.models.viewModels.BrandViewModel;
import com.example.dealership.models.viewModels.ModelViewModel;
import com.example.dealership.repositories.BrandRepository;
import com.example.dealership.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> {
                    BrandViewModel brandViewModel = new BrandViewModel()
                            .setName(brand.getName());

                    brandViewModel.setModels(
                            brand
                                    .getModels()
                                    .stream()
                                    .map(this::map)
                                    .collect(Collectors.toList()));
                    return brandViewModel;
                }).collect(Collectors.toList());
    }

    private ModelViewModel map(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity, ModelViewModel.class);
    }
}
